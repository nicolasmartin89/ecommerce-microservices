package com.nicom.order.order;

import com.nicom.order.customer.CustomerClient;
import com.nicom.order.exception.BusinessException;
import com.nicom.order.kafka.OrderConfirmation;
import com.nicom.order.kafka.OrderProducer;
import com.nicom.order.orderline.OrderLineRequest;
import com.nicom.order.orderline.OrderLineService;
import com.nicom.order.payment.PaymentClient;
import com.nicom.order.payment.PaymentRequest;
import com.nicom.order.product.ProductClient;
import com.nicom.order.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {
        //check the costumer   ---> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Can not create order: No customer exists with the provided ID"));

        //purchase the products ---> product microservice (REST Template)
        var purchaseProducts = this.productClient.purchaseProducts(request.products());
        //persist order
        var order = this.orderRepository.save(orderMapper.toOrder(request));
        //persist order lines
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        //start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //send the order confirmation ---> notification microservice (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(()->new EntityNotFoundException(String.format("No order found con with the provided ID: %d", orderId)));
    }
}
