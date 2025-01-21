package com.nicom.order.order;

import com.nicom.order.customer.CustomerClient;
import com.nicom.order.exception.BusinessException;
import com.nicom.order.orderline.OrderLineRequest;
import com.nicom.order.orderline.OrderLineService;
import com.nicom.order.product.ProductClient;
import com.nicom.order.product.PurchaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        //check the costumer   ---> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Can not create order: No customer exists with the provided ID"));

        //purchase the products ---> product microservice (REST Template)
        this.productClient.purchaseProducts(request.products());
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
        //todo start payment process

        //send the order confirmation ---> notification microservice (kafka)
        return null;
    }
}
