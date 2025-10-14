package com.springboot.deploy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String login() {
        System.out.println("안녕하세요");
        return "login";
    }
}
