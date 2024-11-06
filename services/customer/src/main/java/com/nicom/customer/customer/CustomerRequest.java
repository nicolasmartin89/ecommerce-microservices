package com.nicom.customer.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Debe incluir el nombre del cliente")
        String firstName,
        @NotNull(message = "Debe incluir el apellido del cliente")
        String lastName,
        @NotNull(message = "Debe incluir el email del cliente")
        @Email(message = "El formato de email no es valido")
        String email,
        Address address
) {

}
