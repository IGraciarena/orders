package dev.igraciarena.repository;

import dev.igraciarena.domain.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Repository
public interface OrderItemRepository extends
        JpaRepository<OrderItemEntity, Long> {
}
