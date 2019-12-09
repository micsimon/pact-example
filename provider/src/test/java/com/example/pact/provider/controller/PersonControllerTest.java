package com.example.pact.provider.controller;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import com.example.pact.provider.ProviderApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(SpringRestPactRunner.class)
@Provider("ProviderName")
@PactBroker(host = "localhost")
@SpringBootTest
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController = new PersonController();

//    @TestTarget
//    public MockMvcTarget mockMvcTarget = new MockMvcTarget();

    @TestTarget
    public final Target target = new HttpTarget("http", "localhost", 8080, "/");

    private static ConfigurableWebApplicationContext application;

    @BeforeAll
    public static void setup() {
        application = (ConfigurableWebApplicationContext)
                SpringApplication.run(ProviderApplication.class);
//        mockMvcTarget.setControllers(personController);
    }

    @Test
    @State("getPerson")
    public void asd() {
    }

}
