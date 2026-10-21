package org.formation.coffee.adapter.in.web.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateCoffeeRequest(
        @Nullable String name,
        @Nullable Integer price
) {
}
