package org.formation.coffee.adapter.out.persistence;

import org.formation.coffee.application.port.out.LoadCoffeePort;
import org.formation.coffee.application.port.out.SaveCoffeePort;
import org.formation.coffee.domain.model.Coffee;
import org.formation.coffee.domain.model.CoffeeId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CoffeePersistenceAdapter implements LoadCoffeePort, SaveCoffeePort {

    private final CoffeeJpaRepository repository;
    private final CoffeePersistenceMapper mapper;

    public CoffeePersistenceAdapter(CoffeeJpaRepository coffeeJpaRepository, CoffeePersistenceMapper mapper) {
        this.repository = coffeeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Coffee save(Coffee coffee) {
        CoffeeId id = coffee.getId();
        if (id == null) {
            return mapper.toDomain(repository.save(mapper.toNewEntity(coffee)));
        }
        CoffeeJpaEntity entity = repository.findById(id.value())
                .orElseThrow(() -> new IllegalArgumentException("Coffee with id " + id.value() + " not found"));
        mapper.updateEntity(coffee, entity);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Coffee> findAll() {
        return repository.findAllByOrderByIdAsc().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<Coffee> findById(CoffeeId coffeeId) {
        return repository.findWithReviewsById(coffeeId.value()).map(mapper::toDomain);
    }
}
