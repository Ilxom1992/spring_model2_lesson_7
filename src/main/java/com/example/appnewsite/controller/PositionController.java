package com.example.appnewsite.controller;

import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.PositionDto;
import com.example.appnewsite.payload.UserDto;
import com.example.appnewsite.service.PositionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/position")
public class PositionController {
    final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @PostMapping("/user")
    public HttpEntity<?> register(@RequestBody PositionDto positionDto) {
        final ApiResponse response = positionService.addPosition(positionDto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
}
