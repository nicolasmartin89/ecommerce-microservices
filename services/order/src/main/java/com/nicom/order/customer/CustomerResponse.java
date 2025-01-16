package com.nicom.order.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
