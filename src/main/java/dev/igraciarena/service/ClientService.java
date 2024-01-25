package dev.igraciarena.service;

import dev.igraciarena.domain.entities.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public interface ClientService {
    List<OrderEntity> getAllOrdersByClientId(Long clientId);
}
