package com.example.appnewsite.payload;

import com.example.appnewsite.entity.enums.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PositionDto {
    @NotBlank
    private String name;

    private String description;
    @NotEmpty
    private List<Huquq> huquqList;
}
