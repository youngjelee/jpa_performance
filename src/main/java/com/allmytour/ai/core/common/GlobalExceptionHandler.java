package com.allmytour.ai.core.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleAllException(Exception e) {
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

}
