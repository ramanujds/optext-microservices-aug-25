package com.optext.greetapp.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetService {

    public String getGreetMessage(){
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(LocalTime.NOON)) {
            return "Good Morning!";
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            return "Good Afternoon!";
        } else {            return "Good Evening!";
        }
    }

}
