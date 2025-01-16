package com.scaler.productservice.controllerAdvice;

import com.scaler.productservice.dtos.ExceptionDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<ExceptionDto> handlerArithmaticException() {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("\"ArithmaticException coming from ControllerAdvice Using ExceptionDto");
//        exceptionDto.setDetails("I don't know");
//        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
//                exceptionDto,
//                HttpStatus.NOT_FOUND
//        );
//        return response;
//    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handlerArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException coming from ControllerAdvice",
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerProductNotFoundException(ProductNotFoundException exception) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Pruduct not found Exception");
        exceptionDto.setDetails("Sollution Message"+exception.getProductId()+ " was not found.");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}