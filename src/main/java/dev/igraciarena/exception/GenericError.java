package dev.igraciarena.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericError implements Error {
    private Instant timestamp;
    private Integer code;
    private String description;
}
