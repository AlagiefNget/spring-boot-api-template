package com.example.afnspringstudy.api.v1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Adding property frm config file

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
//    public String sayHello(){
//        return "Hello new user. Have a great day!!!";
//    }
    public String sayHello(){
        return welcomeMessage;
    }
}
