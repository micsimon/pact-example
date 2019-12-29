package com.example.pact.provider.service;

import com.example.pact.provider.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPerson() {
        return Person.builder()
                     .name("Dieter")
                     .age(22)
                     .build();
    }
}
