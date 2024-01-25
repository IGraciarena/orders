package dev.igraciarena.exception;

import lombok.Getter;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
public class UniqueEntityAlreadyExistsException extends ExceptionBase {
    public UniqueEntityAlreadyExistsException(final EntityError error) {
        super(error);
    }
}
