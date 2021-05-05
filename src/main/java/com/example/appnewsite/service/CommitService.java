package com.example.appnewsite.service;

import com.example.appnewsite.config.GetTheUser;
import com.example.appnewsite.entity.Commit;
import com.example.appnewsite.entity.Post;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.CommitDto;
import com.example.appnewsite.repository.CommitRepository;
import com.example.appnewsite.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommitService {
final CommitRepository commitRepository;
final PostRepository postRepository;
GetTheUser getTheUser=new GetTheUser();

    public CommitService(CommitRepository commitRepository, PostRepository postRepository) {
        this.commitRepository = commitRepository;
        this.postRepository = postRepository;
    }

    //  CREATE
    public ApiResponse addCommit(CommitDto commitDto){
        Commit commit=new Commit();
        commit.setText(commit.getText());
        Optional<Post> optionalPost = postRepository.findById(commitDto.getPostId());
        if (!optionalPost.isPresent())
            return new ApiResponse("Post not found",false);
        commit.setPost(optionalPost.get());
        commitRepository.save(commit);
        return new ApiResponse("Commit saved",true);
    }
    //READ BY POST ID
    public ApiResponse getCommit(Long postId){
        List<Commit> allByPostId = commitRepository.findAllByPostId(postId);
        return new ApiResponse("object ",true,allByPostId);
    }
    //UPDATE
    public ApiResponse editCommit(Long id,CommitDto commitDto  ){
        //sistemadagi userga commit tegishli ekanligini tekshirish uchun shu
        // id li commit shu userga tegishli bo'lsa o'zgartirishga ruhsat beriladi
        Optional<Commit> optionalCommit = commitRepository.CommitByUser(id, getTheUser.getCurrentAuditor().get());
        if (!optionalCommit.isPresent())
            return new ApiResponse("Commit not found",false);
        Commit commit = optionalCommit.get();
        commit.setText(commit.getText());
        Optional<Post> optionalPost = postRepository.findById(commitDto.getPostId());
        if (!optionalPost.isPresent())
            return new ApiResponse("Post not found",false);
        commit.setPost(optionalPost.get());
        commitRepository.save(commit);
        return new ApiResponse("Commit edited",true);
    }
    //DELETE
    public ApiResponse delete( Long id ){
        //sistemadagi userga commit tegishli ekanligini tekshirish uchun
        Optional<Commit> optionalCommit = commitRepository.CommitByUser(id, getTheUser.getCurrentAuditor().get());
        if (!optionalCommit.isPresent())
            return new ApiResponse("Commit not deleted",false);
        commitRepository.deleteById(id);
        return new ApiResponse("object deleted",true);
    }

}
