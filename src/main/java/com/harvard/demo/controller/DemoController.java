package com.harvard.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String getHome() {
        return "<h1>Welcome to Spring Security!</h1>";
    }
}
