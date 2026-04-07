package dev.rynwllngtn.agorasystem.exceptions.database;

import dev.rynwllngtn.agorasystem.exceptions.StandardError;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.UserConstraintException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class DatabaseExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = String.format("%s não encontrado!", e.getClassName());
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError exception = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(UserConstraintException.class)
    public ResponseEntity<StandardError> userConstraint(UserConstraintException e, HttpServletRequest request) {
        String error = "User have an open account associated";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError exception = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

}