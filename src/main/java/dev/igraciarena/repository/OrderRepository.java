package dev.igraciarena.repository;

import dev.igraciarena.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByClientId(Long clientId);
}
