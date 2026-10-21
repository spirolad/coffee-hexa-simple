package org.formation.coffee.adapter.out.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "review")
public class ReviewJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CoffeeJpaEntity coffee;

    protected ReviewJpaEntity() {

    }

    @Nullable
    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

}
