package com.example.appnewsite.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class RecursNotFoundExceptions extends RuntimeException {

    private final String resourceName;

    private final String resourceField;

    private final Object object;


}
