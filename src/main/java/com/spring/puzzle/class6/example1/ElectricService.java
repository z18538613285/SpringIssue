package com.spring.puzzle.class6.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricService {

/*    public void charge() throws Exception {
        System.out.println("Electric charging ...");
    }*/

    @Autowired
    ElectricService electricService;

    public void charge() {
        electricService.doCharge();
    }

    public void doCharge() {
        System.out.println("Electric charging ...");
    }
}