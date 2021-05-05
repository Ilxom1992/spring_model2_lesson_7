package com.example.appnewsite.entity;

import com.example.appnewsite.entity.Tamplate.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends AbstractEntity {

    @Column(nullable = false,columnDefinition = "text")
private  String title;
    @Column(nullable = false,columnDefinition = "text")
private  String text;
    @Column(nullable = false,columnDefinition = "text")
private  String url;


}
