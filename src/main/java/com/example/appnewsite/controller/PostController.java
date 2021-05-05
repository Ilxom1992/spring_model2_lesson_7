package com.example.appnewsite.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    //  CREATE
//    @PostMapping
//    public HttpEntity<?> add(@Valid @RequestBody Tarif tarifDto){
//        return ResponseEntity.status(200).body(tarifService.add(tarifDto));
//    }
//    //READ
//    @GetMapping
//    public HttpEntity<?> get(){
//        return ResponseEntity.status(200).body(tarifService.get());
//    }
//    //UPDATE
//    @PutMapping(value = "/{id}")
//    public HttpEntity<?> edit(@Valid @PathVariable Integer id, @RequestBody TarifDto tarifDto ){
//        return ResponseEntity.status(200).body(tarifService.edit(id,tarifDto));
//    }
//    //DELETE
//    @DeleteMapping(value = "/{id}")
//    public HttpEntity<?> delete(@PathVariable Integer id){
//        return ResponseEntity.ok(tarifService.delete(id));
//    }
//    //READ BY ID
//    @GetMapping(value = "/{id}")
//    public HttpEntity<?> getById(@PathVariable Integer id){
//        return ResponseEntity.ok(tarifService.getById(id));
//    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
//}
}