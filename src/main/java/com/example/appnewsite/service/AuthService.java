package com.example.appnewsite.service;

import com.example.appnewsite.entity.User;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.RegisterDto;
import com.example.appnewsite.repository.PositionRepository;
import com.example.appnewsite.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    final UserRepository userRepository;
    final PositionRepository positionRepository;

    public AuthService(UserRepository userRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
    }


    public ApiResponse register(RegisterDto registerDto){
       if (userRepository.existsByUsername(registerDto.getUsername())){
           return new ApiResponse("Bunday user bazada mavjud",false);
       }
//        User user=new User(
//                registerDto.getFullName(),
//                registerDto.getUsername(),
//                null,
//
//
//                            );
    return new ApiResponse();
}
}
