package com.nicom.order.order;

import com.nicom.order.customer.CustomerClient;
import com.nicom.order.exception.BusinessException;
import com.nicom.order.product.ProductClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public Integer createOrder(OrderRequest request) {
        //check the costumer   ---> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Can not create order: No customer exists with the provided ID"));

        //purchase the products ---> product microservice (REST Template)

        //persist order

        //persist order lines

        //start payment process

        //send the order confirmation ---> notification microservice (kafka)
        return null;
    }
}
