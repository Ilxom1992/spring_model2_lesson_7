package com.example.appnewsite.controller;

import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.PositionDto;
import com.example.appnewsite.payload.UserDto;
import com.example.appnewsite.service.PositionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/position")
public class PositionController {
    final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
   @PreAuthorize(value = "hasAnyAuthority('ADD_ROLE')")
    @PostMapping("/role")
    public HttpEntity<?> addLavozim(@RequestBody PositionDto positionDto) {
        final ApiResponse response = positionService.addPosition(positionDto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
    @PreAuthorize(value = "hasAnyAuthority('EDIT_ROLE')")
    @PostMapping("/role/{id}")
    public HttpEntity<?> editLavozim(@PathVariable Long id, @RequestBody PositionDto positionDto) {
        final ApiResponse response = positionService.editPosition(id,positionDto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
}
