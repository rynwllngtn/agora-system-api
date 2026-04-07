package dev.rynwllngtn.agorasystem.exceptions.business;

import dev.rynwllngtn.agorasystem.exceptions.StandardError;
import dev.rynwllngtn.agorasystem.exceptions.business.BusinessException.InsufficientFundsException;
import dev.rynwllngtn.agorasystem.exceptions.business.BusinessException.InvalidAmountException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<StandardError> invalidAmount(InvalidAmountException e, HttpServletRequest request) {
        String error = "Valor fornecido é invalido para essa operação!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError exception = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<StandardError> insufficientFunds(InsufficientFundsException e, HttpServletRequest request) {
        String error = "Valor fornecido é insuficiente para essa operação!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError exception = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

}