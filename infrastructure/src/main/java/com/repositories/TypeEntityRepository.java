package infrastructure.src.main.java.com.repositories;

import infrastructure.src.main.java.com.entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeEntityRepository extends JpaRepository<TypeEntity, Long> {

    Optional<TypeEntity> findByTypeName(String typeName);
}