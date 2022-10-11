package com.k1m743hyun.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class demoService {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}