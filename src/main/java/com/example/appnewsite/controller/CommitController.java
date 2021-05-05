package com.example.appnewsite.controller;

import com.example.appnewsite.payload.CommitDto;
import com.example.appnewsite.service.CommitService;
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
@RequestMapping("/commit")
public class CommitController {
final CommitService commitService;

    public CommitController(CommitService commitService) {
        this.commitService = commitService;
    }

    //  CREATE
    @PreAuthorize(value = "hasAnyAuthority('ADD_COMMIT')")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody CommitDto commitDto){
        return ResponseEntity.status(200).body(commitService.addCommit(commitDto));
    }
    //READ
    @GetMapping("/{postId}")
    public HttpEntity<?> get(@PathVariable Long postId){
        return ResponseEntity.status(200).body(commitService.getCommit(postId));
    }
    //UPDATE
    @PreAuthorize(value = "hasAnyAuthority('EDIT_COMMIT')")
    @PutMapping(value = "/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @Valid @RequestBody CommitDto commitDto){
        return ResponseEntity.status(200).body(commitService.editCommit(id,commitDto));
    }
    //DELETE
    @PreAuthorize(value = "hasAnyAuthority('DELETE_MY_COMMIT')")
    @DeleteMapping(value = "/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(commitService.delete(id));
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
