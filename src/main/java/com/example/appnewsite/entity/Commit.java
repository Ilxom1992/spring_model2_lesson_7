package com.example.appnewsite.entity;

import com.example.appnewsite.entity.Tamplate.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commit extends AbstractEntity {

    @Column(nullable = false,columnDefinition = "text")
    private  String text;


    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
