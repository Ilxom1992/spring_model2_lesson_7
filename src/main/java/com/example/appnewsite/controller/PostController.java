package com.example.appnewsite.controller;

import com.example.appnewsite.payload.PostDto;
import com.example.appnewsite.service.PostService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //  CREATE
    @PreAuthorize(value = "hasAnyAuthority('ADD_POST')")
    @PostMapping
    public HttpEntity<?> addPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.status(200).body(postService.addPost(postDto));
    }
    //READ
    @GetMapping
    public HttpEntity<?> get(){
        return ResponseEntity.status(200).body(postService.getAllPost());
    }
    //UPDATE
    @PreAuthorize(value = "hasAnyAuthority('EDIT_POST')")
    @PutMapping(value = "/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @Valid @RequestBody  PostDto postDto){
        return ResponseEntity.status(200).body(postService.editPost(id,postDto));
    }
    //DELETE
    @PreAuthorize(value = "hasAnyAuthority('DELETE_POST')")
    @DeleteMapping(value = "/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(postService.deletePost(id));
    }
    //READ BY ID
    @GetMapping(value = "/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getByIdPost(id));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
