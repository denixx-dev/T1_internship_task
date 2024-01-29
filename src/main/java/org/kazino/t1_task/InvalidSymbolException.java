package org.kazino.t1_task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidSymbolException extends Exception {
    public InvalidSymbolException(String message){
        super(message);
    }
}
