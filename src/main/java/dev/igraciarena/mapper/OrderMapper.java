package dev.igraciarena.mapper;

import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.domain.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Mapper
public interface OrderMapper {
  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  OrderEntity map(Order order);

  Order mapToModel(OrderEntity order);
}
