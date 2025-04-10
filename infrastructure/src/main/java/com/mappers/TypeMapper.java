package infrastructure.src.main.java.com.mappers;

import domain.src.java.com.model.Type;
import infrastructure.src.main.java.com.entities.TypeEntity;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

    public Type toModel(TypeEntity typeEntity) {
        if (typeEntity == null) {
            return null;
        }

        Type type = new Type();
        type.setId(typeEntity.getId());
        type.setType(typeEntity.getType());
        return type;
    }

    public TypeEntity toEntity(Type type) {
        if (type == null) {
            return null;
        }

        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setId(type.getId());
        typeEntity.setType(type.getType());
        return typeEntity;
    }
}

