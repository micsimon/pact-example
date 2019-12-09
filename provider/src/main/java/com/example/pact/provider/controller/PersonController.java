package com.example.pact.provider.controller;

import com.example.pact.provider.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping(value = "/person", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Person getPerson() {
        return Person.builder()
                     .age(11)
                     .name("Hans")
                     .build();
    }
}
