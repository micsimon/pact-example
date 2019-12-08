package com.example.pact.consumer.controller;

import com.example.pact.consumer.model.Person;
import com.example.pact.consumer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ActionController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        Person person = personService.getPersonFromProvider();
        person.setName(person.getName() + " Peter");
        return Collections.singletonList(person);
    }

}
