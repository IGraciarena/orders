package dev.igraciarena.repository;

import dev.igraciarena.domain.entities.OrderEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {}
