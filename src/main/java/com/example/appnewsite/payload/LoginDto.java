package com.example.appnewsite.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

}
