package dev.igraciarena.mapper;

import dev.igraciarena.domain.dtos.request.OrderCreateRequest;
import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.domain.models.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Mapper(uses = {OrderItemMapper.class, AddressMapper.class, ClientMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderModel mapToModel(OrderEntity order);

    default Page<OrderModel> mapToPageModel(Page<OrderEntity> ordersPaginated) {
        return ordersPaginated.map(OrderMapper.INSTANCE::mapToModel);
    }

    @Mapping(target = "createdDate",
            expression = "java(java.time.Instant.now())")
    @Mapping(target = "modifiedDate",
            expression = "java(java.time.Instant.now())")
    OrderEntity mapToEntity(OrderCreateRequest order);
}
