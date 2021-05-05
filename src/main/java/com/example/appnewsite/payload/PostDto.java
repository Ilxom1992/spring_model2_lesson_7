package com.example.appnewsite.payload;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PostDto {

    private  String title;

    private  String text;

    private  String url;
}
