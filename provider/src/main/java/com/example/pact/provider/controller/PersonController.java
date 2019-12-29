package com.example.pact.provider.controller;

import com.example.pact.provider.model.Person;
import com.example.pact.provider.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/person", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Person getPerson() {
        return personService.getPerson();
    }
}
