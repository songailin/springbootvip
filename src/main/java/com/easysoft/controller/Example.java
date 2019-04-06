package com.easysoft.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello SpringBoot.";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class);
    }
}