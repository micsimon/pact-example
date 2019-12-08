package com.example.pact.consumer.service;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.pact.consumer.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PersonServiceTest {

    private PersonService underTest;

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("Provider", "localhost", 8080, this);

    @Before
    public void setup() {
        underTest = new PersonService();
    }

    @Pact(consumer = "JUnitRuleConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder.given("")
                      .uponReceiving("Pact JVM example")
                      .path("/person")
                      .method("GET")
                      .willRespondWith()
                      .status(200)
                      .body("{" +
                              "\name\" : \"Hans\"" +
                              "\"age\"+:\"113\"" +
                              "}")
                      .toPact();
    }

    @Test
    public void firstPactTest() {

        Person actual = underTest.getPersonFromProvider();

        Assert.assertEquals("Hans", actual.getName());
        Assert.assertEquals(11, actual.getAge());
    }
}
