package com.reactivespring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Oauth {
	@GetMapping("/login")
    public String login() {
        return "login";  
}
}
