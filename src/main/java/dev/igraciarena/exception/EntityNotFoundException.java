package dev.igraciarena.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
public class EntityNotFoundException extends ExceptionBase {

    @Serial
    private static final long serialVersionUID = 962237408315663159L;

    public EntityNotFoundException(final EntityError error) {
        super(error);
    }
}
