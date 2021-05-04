package com.example.appnewsite.service;

import com.example.appnewsite.entity.User;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.UserDto;
import com.example.appnewsite.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse addUser(UserDto userDto, HttpServletRequest httpServletRequest) {
        return null;
    }
}
