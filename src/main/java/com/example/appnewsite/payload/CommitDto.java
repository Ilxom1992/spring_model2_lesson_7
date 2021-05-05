package com.example.appnewsite.payload;

import com.example.appnewsite.entity.Post;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
public class CommitDto {
    private  String text;
    private Long postId;

}
