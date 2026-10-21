package org.formation.coffee.application.port.in;

import jakarta.annotation.Nullable;
import org.formation.coffee.domain.model.CoffeeId;
import org.formation.coffee.domain.model.Price;

import java.math.BigDecimal;
import java.util.Objects;

public record UpdateCoffeeCommand(
        CoffeeId id,
        @Nullable String name,
        @Nullable Price price
) {

    public UpdateCoffeeCommand {
        Objects.requireNonNull(id, "id must not be null");
    }

}
