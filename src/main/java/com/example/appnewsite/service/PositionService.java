package com.example.appnewsite.service;

import com.example.appnewsite.entity.Position;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.PositionDto;
import com.example.appnewsite.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public ApiResponse addPosition(PositionDto positionDto) {
        boolean existsByName = positionRepository.existsByName(positionDto.getName());
        if (existsByName){
            return new ApiResponse("Bunday lavozim bor",false);
        }
        Position position=new Position();
        position.setName(positionDto.getName());
        position.setDescriptin(position.getDescriptin());
        position.setHuquqList(position.getHuquqList());
        positionRepository.save(position);
        return new ApiResponse("Lavozim saqlandi",true);

    }
}
