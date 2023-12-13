package dev.igraciarena.domain.models;

import java.util.UUID;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public record Client(UUID id, String firstName, String lastName) {}
