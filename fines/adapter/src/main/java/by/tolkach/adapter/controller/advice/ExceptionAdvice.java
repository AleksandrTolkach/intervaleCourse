package by.tolkach.adapter.controller.advice;

import by.tolkach.adapter.model.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> httpClientErrorExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
