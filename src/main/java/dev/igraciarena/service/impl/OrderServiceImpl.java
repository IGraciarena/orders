package dev.igraciarena.service.impl;

import dev.igraciarena.domain.dtos.request.OrderCreateRequest;
import dev.igraciarena.domain.entities.OrderEntity;
import dev.igraciarena.exception.EntityNotFoundException;
import dev.igraciarena.mapper.OrderMapper;
import dev.igraciarena.repository.OrderRepository;
import dev.igraciarena.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.igraciarena.exception.EntityError.ORDER_ID_NOT_FOUND;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final OrderMapper ORDER_MAPPER = OrderMapper.INSTANCE;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderEntity getOrderById(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new EntityNotFoundException(ORDER_ID_NOT_FOUND));
    }

    @Override
    public OrderEntity saveOrder(final OrderCreateRequest order) {
        var orderMapped = ORDER_MAPPER.mapToEntity(order);
        return orderRepository.save(orderMapped);
    }

    @Override
    public List<OrderEntity> findAllByClientId(final Long clientId) {
        return orderRepository.findAllByClientId(clientId);
    }
}
