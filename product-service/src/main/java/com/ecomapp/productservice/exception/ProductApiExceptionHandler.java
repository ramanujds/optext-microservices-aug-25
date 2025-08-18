package com.ecomapp.productservice.exception;

import com.ecomapp.productservice.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ProductApiExceptionHandler {



    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleItemNotFoundException(Exception ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseDto response = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.status(status).body(response);

    }


    @ExceptionHandler(DuplicateItemException.class)
    public ProblemDetail handleDuplicateItemException(Exception ex){
        var response =  ProblemDetail.forStatus(HttpStatus.CONFLICT);
        response.setDetail(ex.getMessage());
        response.setTitle("Duplicate Item");
        return response;
    }



}
