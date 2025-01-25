package com.nicom.order.payment;

import com.nicom.order.customer.CustomerResponse;
import com.nicom.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customerResponse
) {
}
