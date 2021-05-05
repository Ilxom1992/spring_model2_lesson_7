package com.example.appnewsite.service;

import com.example.appnewsite.entity.Post;
import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.PostDto;
import com.example.appnewsite.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //  CREATE
    public ApiResponse addPost(PostDto postDto){
Post post=new Post();
post.setTitle(postDto.getTitle());
post.setText(postDto.getText());
post.setUrl(postDto.getTitle()+postDto.getText().substring(10));
postRepository.save(post);
        return new ApiResponse("Post saved",true);
    }
    //READ ALL POST FOR ADDMIN
    public ApiResponse getAllPost(){
        List<Post> posts = postRepository.findAll();
        return new ApiResponse("object ",true,posts);
    }
    //UPDATE
    public ApiResponse editPost(Long id, PostDto postDto ){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent())
            return new ApiResponse(" Not found",false);
        Post post = optionalPost.get();
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        post.setUrl(postDto.getTitle()+postDto.getText().substring(10));
        postRepository.save(post);
        return new ApiResponse("Post edited",true);
    }
    //DELETE
    public ApiResponse deletePost( Long id ){
        postRepository.deleteById(id);
        return new ApiResponse("Post deleted",true);

    }
    //READ BY ID
    public ApiResponse getByIdPost( Long id ){
        Optional<Post> post = postRepository.findById(id);
        return new ApiResponse("object deleted",true, post);
    }
}
