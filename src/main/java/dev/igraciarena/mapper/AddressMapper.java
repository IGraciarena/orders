package dev.igraciarena.mapper;

import dev.igraciarena.domain.dtos.request.AddressCreateRequest;
import dev.igraciarena.domain.entities.AddressEntity;
import dev.igraciarena.domain.models.AddressModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressModel mapToModel(AddressEntity address);

    @Mapping(target = "createdDate",
            expression = "java(java.time.Instant.now())")
    @Mapping(target = "modifiedDate",
            expression = "java(java.time.Instant.now())")
    AddressEntity mapToEntity(AddressCreateRequest address);
}
