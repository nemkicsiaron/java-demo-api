package com.example.demoapi.controller;

import com.example.demoapi.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;

@RestController
@RequestMapping("/todos")
public class ProductController {

    @GetMapping("/hello")
    public ResponseEntity<String> getProduct() {
        try {
            return new ResponseEntity<>("Hello World", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/demo")
    public ResponseEntity<Todo> getDemoProduct() {
        try {
            Todo todo = new Todo();
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
