package com.example.appnewsite.entity;

import com.example.appnewsite.entity.Tamplate.AbstractEntity;
import com.example.appnewsite.entity.enums.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Position extends AbstractEntity {

    private  String name;

//    @Enumerated(value = EnumType.STRING)
//    private PositionTypes positionTypes;
    @ElementCollection
    private List<Huquq> huquqList;

}
