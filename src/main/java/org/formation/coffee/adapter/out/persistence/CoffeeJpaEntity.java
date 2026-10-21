package org.formation.coffee.adapter.out.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "coffee")
public class CoffeeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private List<ReviewJpaEntity> reviews = new ArrayList<>();

    protected CoffeeJpaEntity() {}

    @Nullable
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<ReviewJpaEntity> getReviews() {
        return reviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
