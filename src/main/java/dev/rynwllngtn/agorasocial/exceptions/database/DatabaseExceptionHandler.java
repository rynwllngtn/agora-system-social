package dev.rynwllngtn.agorasocial.exceptions.database;

import dev.rynwllngtn.agorasocial.exceptions.StandardError;
import dev.rynwllngtn.agorasocial.exceptions.database.DatabaseException.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class DatabaseExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        String error = String.format("O %s não foi encontrado!", e.getClassName());
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ObjectConstrainException.class)
    public ResponseEntity<StandardError> objectConstrain(ObjectConstrainException e, HttpServletRequest request) {
        String error = "Dados incorretos!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}