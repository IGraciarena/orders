package dev.igraciarena.domain.models;

import java.util.UUID;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public record Address(
    UUID id, String lineNumber, String city, String state, String country, String postalCode) {}
