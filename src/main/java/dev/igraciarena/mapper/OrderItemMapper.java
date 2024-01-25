package dev.igraciarena.mapper;

import dev.igraciarena.domain.dtos.request.OrderItemCreateRequest;
import dev.igraciarena.domain.entities.OrderItemEntity;
import dev.igraciarena.domain.models.OrderItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemModel mapToModel(OrderItemEntity orderItem);

    List<OrderItemModel> mapToModel(List<OrderItemEntity> orderItems);

    @Mapping(target = "createdDate",
            expression = "java(java.time.Instant.now())")
    @Mapping(target = "modifiedDate",
            expression = "java(java.time.Instant.now())")
    OrderItemEntity mapToEntity(OrderItemCreateRequest orderItem);

    List<OrderItemEntity> mapToEntity(List<OrderItemCreateRequest> orderItems);
}
