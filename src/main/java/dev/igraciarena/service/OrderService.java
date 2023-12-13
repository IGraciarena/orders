package dev.igraciarena.service;

import dev.igraciarena.domain.models.Order;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Service
public interface OrderService {
  Order getOrderById(UUID id);
}
