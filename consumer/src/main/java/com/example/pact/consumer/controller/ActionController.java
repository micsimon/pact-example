package com.example.pact.consumer.controller;

import com.example.pact.consumer.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class ActionController {

    @GetMapping("/persons")
    public List<Person> getPersons() {
        Person person = getPersonFromProvider();
        person.setName(person.getName() + " Peter");
        return Collections.singletonList(person);
    }

    private Person getPersonFromProvider() {
        String uri = "http://localhost:8080/person";
        return new RestTemplate().getForObject(uri, Person.class);
    }
}
