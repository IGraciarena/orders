package dev.igraciarena.exception.handler;

import dev.igraciarena.exception.EntityNotFoundException;
import dev.igraciarena.exception.GenericError;
import dev.igraciarena.exception.UniqueEntityAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static dev.igraciarena.util.ConstantUtil.NOW;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ivan.graciarena
 * @project skill.management
 */
@Slf4j
@ControllerAdvice
public class RestResponseExceptionHandler {
    private static final String LOG_ERROR = "Error: {} - {}";

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<GenericError> handleEntityNotFoundException() {
        GenericError errorResponse = new GenericError(NOW, NOT_FOUND.value(),
                "Entity was not found");
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }

    @ExceptionHandler({UniqueEntityAlreadyExistsException.class})
    public ResponseEntity<GenericError> handleUniqueEntityAlreadyExistsException(
            final UniqueEntityAlreadyExistsException ex) {
        log.error(LOG_ERROR, ex.getError().getCode(),
                ex.getError().getDescription());
        GenericError errorResponse = new GenericError(NOW, BAD_REQUEST.value(),
                "Entity Already exists");
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }
}

