package com.example.pact.consumer.service;

import com.example.pact.consumer.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    public Person getPersonFromProvider() {
        String uri = "http://localhost:8080/person";
        return new RestTemplate().getForObject(uri, Person.class);
    }
}
