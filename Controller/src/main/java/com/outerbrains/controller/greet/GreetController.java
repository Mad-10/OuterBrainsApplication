package com.outerbrains.controller.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/Greet")
public class GreetController {
    @PostMapping("/greeting")
    ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello!");
    }
}

