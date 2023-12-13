package dev.igraciarena.domain.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public record Order(
    UUID id,
    BigDecimal totalPrice,
    BigDecimal deliveryCost,
    String status,
    Address address,
    List<OrderItem> items) {}
