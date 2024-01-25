package dev.igraciarena.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

import static dev.igraciarena.util.ConstantUtil.NOW;
import static dev.igraciarena.util.MessageUtils.getNotFoundErrorMessage;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
@AllArgsConstructor
public enum EntityError {
    ORDER_ID_NOT_FOUND(NOT_FOUND.value(), getNotFoundErrorMessage("Order"),
            NOW),
    CLIENT_NOT_FOUND(NOT_FOUND.value(), getNotFoundErrorMessage("Client"), NOW);

    private final int code;
    private final String description;
    private final Instant timestamp;
}
