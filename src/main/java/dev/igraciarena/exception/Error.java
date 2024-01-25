package dev.igraciarena.exception;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
public interface Error extends Serializable {

    Integer getCode();


    String getDescription();

    Instant getTimestamp();
}
