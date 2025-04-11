package src.java.com.repositories;

import domain.src.java.com.model.Type;

import java.util.List;
import java.util.Optional;

public interface TypeRepository {

    Type save(Type type);

    Optional<Type> findById(Long id);

    List<Type> findAll();

    Type update(Type type);

    void deleteById(Long id);

    boolean existsByName(String name);

    boolean existsById(Long id);
}