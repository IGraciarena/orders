package dev.igraciarena.domain.models;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public record OrderItem(UUID id, BigDecimal totalPrice, BigDecimal deliveryCost, String status) {}
