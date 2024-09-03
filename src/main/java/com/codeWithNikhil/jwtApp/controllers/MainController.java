package com.codeWithNikhil.jwtApp.controllers;

import com.codeWithNikhil.jwtApp.model.User;
import com.codeWithNikhil.jwtApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "Hello default to World";
    }

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }

    @RequestMapping("/register")
    public String register(@RequestBody User user){
        System.out.println("saving this user to database -> "+user.getUsername());
        return userService.saveUser(user);
    }

    @RequestMapping("/home1")
    public String home1(){
        return "returning from home";
    }
}
