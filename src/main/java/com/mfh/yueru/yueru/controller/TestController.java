package com.mfh.yueru.yueru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mfh")
public class TestController {

    @GetMapping
    public Object get(){
        return "ok";
    }
}
