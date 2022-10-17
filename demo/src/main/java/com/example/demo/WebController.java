package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/get")
    public ResponseEntity<Void> get(){
        return ResponseEntity.ok().build();
    }
    @PostMapping("/post")
    public ResponseEntity<Void> post(){
        return ResponseEntity.ok().build();
    }
}
