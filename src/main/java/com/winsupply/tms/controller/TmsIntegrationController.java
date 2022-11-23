package com.winsupply.tms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmsIntegrationController {

    @GetMapping("/tmstest")
    public void test(){
        System.out.println(" This is tms test controller ");

    }
}
