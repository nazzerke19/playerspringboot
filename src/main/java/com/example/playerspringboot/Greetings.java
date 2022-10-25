package com.example.playerspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetings {
    @RequestMapping("/")
    public String greeting(){
        return "Nazerkeshka";
    }
}
