package com.example.pact.provider.controller;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import com.example.pact.provider.ProviderApplication;
import com.example.pact.provider.model.Person;
import com.example.pact.provider.service.PersonService;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRestPactRunner.class)
@Provider("ProviderName")
@PactBroker(host = "localhost")
@SpringBootTest(classes = ProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonControllerTest {

    @MockBean
    private PersonService personService;

    @TestTarget
    public final Target target = new HttpTarget(8080);

    @State(value = "getPerson")
    public void state_getPerson() {
        Person person = Person.builder()
                              .name("Hans")
                              .age(11)
                              .build();

        Mockito.when(personService.getPerson())
               .thenReturn(person);
    }
}
