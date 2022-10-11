package com.k1m743hyun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class demoController {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}