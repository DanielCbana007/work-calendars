package application.src.main.java.com.services;

import domain.src.java.com.model.Type;
import infrastructure.src.main.java.com.entities.TypeEntity;
import infrastructure.src.main.java.com.repositories.TypeEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class TypeService {

    private TypeEntityRepository typeEntityRepository;

    public Type createType(Type type) {
        TypeEntity typeEntity = mapToEntity(type);
        typeEntity = typeEntityRepository.save(typeEntity);
        return mapToModel(typeEntity);
    }

    public List<Type> getAllTypes() {
        List<TypeEntity> typeEntities = typeEntityRepository.findAll();
        return typeEntities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public Optional<Type> getTypeById(Long id) {
        Optional<TypeEntity> typeEntity = typeEntityRepository.findById(id);
        return typeEntity.map(this::mapToModel);
    }

    public Type updateType(Long id, Type type) {
        if (typeEntityRepository.existsById(id)) {
            TypeEntity typeEntity = mapToEntity(type);
            typeEntity.setId(id);
            typeEntity = typeEntityRepository.save(typeEntity);
            return mapToModel(typeEntity);
        }
        return null;
    }

    public void deleteType(Long id) {
        typeEntityRepository.deleteById(id);
    }

    private Type mapToModel(TypeEntity typeEntity) {
        return new Type(
                typeEntity.getId(),
                typeEntity.getType()
        );
    }

    private TypeEntity mapToEntity(Type type) {
        return new TypeEntity(
                type.getId(),
                type.getType()
        );
    }
}
