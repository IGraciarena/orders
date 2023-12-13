package dev.igraciarena.service.impl;

import static dev.igraciarena.exception.EntityError.ORDER_ID_NOT_FOUND;

import dev.igraciarena.domain.models.Order;
import dev.igraciarena.exception.EntityNotFoundException;
import dev.igraciarena.mapper.OrderMapper;
import dev.igraciarena.repository.OrderRepository;
import dev.igraciarena.service.OrderService;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private static final OrderMapper orderMapper = OrderMapper.INSTANCE;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order getOrderById(UUID id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(ORDER_ID_NOT_FOUND));

    return orderMapper.mapToModel(order);
  }
}
