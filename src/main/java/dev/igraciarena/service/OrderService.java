package dev.igraciarena.service;

import dev.igraciarena.domain.dtos.request.OrderCreateRequest;
import dev.igraciarena.domain.entities.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public interface OrderService {
    OrderEntity getOrderById(Long orderId);

    OrderEntity saveOrder(OrderCreateRequest order);

    List<OrderEntity> findAllByClientId(Long clientId);
}
