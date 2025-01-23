package com.nicom.order.kafka;

import com.nicom.order.customer.CustomerResponse;
import com.nicom.order.order.PaymentMethod;
import com.nicom.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
