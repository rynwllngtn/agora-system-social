package dev.rynwllngtn.agorasocial.exceptions.validation;

import dev.rynwllngtn.agorasocial.exceptions.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(erro -> {
                    String field = erro.getField();
                    String message = erro.getDefaultMessage();
                    erros.put(field, message);});

        ValidationError exception = new ValidationError(Instant.now(),
                status.value(),
                erros,
                request.getRequestURI());

        return ResponseEntity.status(status).body(exception);
    }

}