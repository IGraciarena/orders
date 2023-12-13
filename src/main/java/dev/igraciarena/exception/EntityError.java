package dev.igraciarena.exception;

import static dev.igraciarena.util.ConstantUtil.NOW;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
@AllArgsConstructor
public enum EntityError {
  ORDER_ID_NOT_FOUND(NOT_FOUND.value(), "The Order UUID that was provided was not found.", NOW);

  private final int code;
  private final String description;
  private final Instant timestamp;
}
