package org.formation.coffee.domain.model;

import jakarta.annotation.Nullable;
import org.formation.coffee.domain.exception.DomainValidationException;

import java.util.List;
import java.util.Objects;

public final class Coffee {

    public static final int MAX_COFFEE_NAME_LENGTH = 255;

    private final @Nullable CoffeeId id;
    private String name;
    private Price price;
    private final List<Review> reviews;

    public Coffee(@Nullable CoffeeId id, String name, Price price, List<Review> reviews) {
        this.id = id;
        this.name = requireValidName(name);
        this.price = Objects.requireNonNull(price, "price must not be null");
        this.reviews = List.copyOf(reviews);
    }

    public static Coffee create(String name, Price price) {
        return new Coffee(null, name, price, List.of());
    }

    public static Coffee reconstitute(CoffeeId id, String name, Price price, List<Review> reviews) {
        return new Coffee(id, name, price, reviews);
    }

    public void rename(String newName) {
        this.name = requireValidName(newName);
    }

    public void changePrice(Price newPrice) {
        this.price = Objects.requireNonNull(newPrice, "newPrice must not be null");
    }

    public boolean isNew() {
        return this.id == null;
    }

    public static String requireValidName(String name) {
        if (name == null || name.isBlank()) {
            throw new DomainValidationException("name must not be null or blank");
        }
        if (name.length() > MAX_COFFEE_NAME_LENGTH) {
            throw new DomainValidationException("name must not exceed " + MAX_COFFEE_NAME_LENGTH + " characters");
        }
        return name;
    }

    public @Nullable CoffeeId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Coffee[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", reviews=" + reviews +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Coffee coffee && Objects.equals(id, coffee.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : System.identityHashCode(this);
    }

}
