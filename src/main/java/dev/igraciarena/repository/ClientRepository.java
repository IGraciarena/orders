package dev.igraciarena.repository;

import dev.igraciarena.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
