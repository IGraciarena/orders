package dev.igraciarena.exception;

import lombok.Getter;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
public class ExceptionBase extends RuntimeException {

  private final EntityError error;

  public ExceptionBase(EntityError error) {
    this.error = error;
  }
}
