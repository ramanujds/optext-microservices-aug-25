package com.optext.greetapp.api;

import com.optext.greetapp.service.GreetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private GreetService greetService;

    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }


    @GetMapping
    public String greet() {
        return greetService.getGreetMessage();
    }

}
