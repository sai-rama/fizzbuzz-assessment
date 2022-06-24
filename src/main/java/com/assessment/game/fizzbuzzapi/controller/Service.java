package com.assessment.game.fizzbuzzapi.controller;

import org.springframework.stereotype.Component;

import java.util.StringJoiner;
import java.util.stream.IntStream;

@Component
public class Service {

    public String getResultStringFor1To100() {
        StringJoiner resultString = new StringJoiner(",");
        IntStream.rangeClosed(1,100)
                .mapToObj(number -> number % 3 == 0?(number%5==0?"FizzBuzz":"Fizz"):(number % 5==0?"Buzz": number+""))
                .forEach(value -> {
                    resultString.add(value);
                });
        return resultString.toString();
    }

    public String getResultStringFor1ToN(Integer maxNumber) {
        StringJoiner resultString = new StringJoiner(",");
        IntStream.rangeClosed(1,maxNumber)
                .mapToObj(number -> number % 3 == 0?(number%5==0?"FizzBuzz":"Fizz"):(number % 5==0?"Buzz": number+""))
                .forEach(value -> {
                    resultString.add(value);
                });
        return resultString.toString();
    }




}
