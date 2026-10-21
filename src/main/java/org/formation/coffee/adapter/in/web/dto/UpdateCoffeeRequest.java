package org.formation.coffee.adapter.in.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateCoffeeRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Origin is required")
        String origin,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be strictly positive")
        BigDecimal price,

        @NotBlank(message = "Currency is required")
        String currency
) {
}
