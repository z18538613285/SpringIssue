package com.spring.puzzle.class6.example1;

import org.springframework.stereotype.Service;

@Service
public class ElectricService {

    public void charge() throws Exception {
        System.out.println("Electric charging ...");
    }

}