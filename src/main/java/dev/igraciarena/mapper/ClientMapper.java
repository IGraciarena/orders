package dev.igraciarena.mapper;

import dev.igraciarena.domain.dtos.request.ClientCreateRequest;
import dev.igraciarena.domain.entities.ClientEntity;
import dev.igraciarena.domain.models.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientModel mapToModel(ClientEntity client);

    @Mapping(target = "createdDate",
            expression = "java(java.time.Instant.now())")
    @Mapping(target = "modifiedDate",
            expression = "java(java.time.Instant.now())")
    ClientEntity mapToEntity(ClientCreateRequest client);
}
