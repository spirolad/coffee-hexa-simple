package org.formation.coffee.domain.model;

import org.formation.coffee.domain.exception.DomainValidationException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public record Price(int amount) {

    private static final int MIN = 0;
    private static final int MAX = 200;

    public Price {

        if (amount < MIN || amount > MAX) {
            throw new DomainValidationException("Price must be between " + MIN + " and " + MAX);
        }
    }


}
