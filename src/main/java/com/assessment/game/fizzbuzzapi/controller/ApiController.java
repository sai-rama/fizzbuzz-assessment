package com.assessment.game.fizzbuzzapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.StringJoiner;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/fizzbuzz/api")
public class ApiController {

     @Autowired
     Service service;


    @GetMapping("/print1to100")
    public String apply1To100FizzBuzzAlgorithm(){
        return service.getResultStringFor1To100();
    }

    @GetMapping("/print1ToNNumbers/{number}")
    public String apply1To100FizzBuzzAlgorithm(@PathVariable("number") Integer maxValue){
       return service.getResultStringFor1ToN(maxValue);
    }

}
