package dev.igraciarena.repository;

import dev.igraciarena.domain.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
