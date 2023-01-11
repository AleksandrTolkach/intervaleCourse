package by.tolkach.smev.controller.advice;

import by.tolkach.smev.model.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
