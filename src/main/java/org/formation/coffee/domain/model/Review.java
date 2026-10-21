package org.formation.coffee.domain.model;

import org.formation.coffee.domain.exception.DomainValidationException;

import java.time.Instant;
import java.util.Objects;

public record Review(ReviewId id, String author, String comment, int rating) {

    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;

    public Review {
        Objects.requireNonNull(id, "Review id cannot be null");
        Objects.requireNonNull(comment, "Comment cannot be null");

        if (author == null || author.isBlank()) {
            throw new DomainValidationException("Author cannot be null or blank");
        }
        if (rating < MIN_RATING || rating > MAX_RATING) {
            throw new DomainValidationException("Rating must be between " + MIN_RATING + " and " + MAX_RATING);
        }
    }

}