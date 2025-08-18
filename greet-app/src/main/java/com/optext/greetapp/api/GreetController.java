package com.optext.greetapp.api;

import com.optext.greetapp.dto.MessageResponseDto;
import com.optext.greetapp.service.GreetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class GreetController {

    private GreetService greetService;

    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public MessageResponseDto greet() {

        var msg = greetService.getGreetMessage();
        var response = new MessageResponseDto(msg, LocalDate.now(), LocalTime.now());
        return response;

    }

}
