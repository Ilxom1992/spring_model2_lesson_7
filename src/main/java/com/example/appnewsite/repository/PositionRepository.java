package com.example.appnewsite.repository;

import com.example.appnewsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PositionRepository extends JpaRepository<Position,Long> {
}
