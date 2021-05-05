package com.example.appnewsite.service;

import com.example.appnewsite.entity.User;
import com.example.appnewsite.exceptions.RecursNotFoundExceptions;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.RegisterDto;
import com.example.appnewsite.repository.PositionRepository;
import com.example.appnewsite.repository.UserRepository;
import com.example.appnewsite.utils.AppConstants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    final UserRepository userRepository;
    final PositionRepository positionRepository;
    final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PositionRepository positionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public ApiResponse register(RegisterDto registerDto){
        if (!registerDto.getPassword().equals(registerDto.getPrePassword())){
            return new ApiResponse("parol mos emas",false);
        }
       if (userRepository.existsByUsername(registerDto.getUsername())){
           return new ApiResponse("Bunday user bazada mavjud",false);
       }


        User user=new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                positionRepository.findByName(AppConstants.USER).orElseThrow(()->new
                                RecursNotFoundExceptions("Lavozim","Name",AppConstants.USER)),
true
        );
       userRepository.save(user);
    return new ApiResponse("user saved",true);
}

    public UserDetails loadUserByUsername(String username) {
  return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
