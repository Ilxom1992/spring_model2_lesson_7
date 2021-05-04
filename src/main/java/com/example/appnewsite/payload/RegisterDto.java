package com.example.appnewsite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
@NotNull
    private String fullName;

@NotNull
    private String username;

@NotNull
    private String password;

@NotNull
    private String prePassword;

}
