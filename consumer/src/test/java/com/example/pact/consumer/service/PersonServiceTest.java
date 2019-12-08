package com.example.pact.consumer.service;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.pact.consumer.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PersonServiceTest {

    private PersonService underTest;

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("ProviderName", null, 8080, this);

    @Before
    public void setup() {
        underTest = new PersonService();
    }

    @Pact(consumer = "ConsumerName")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder.uponReceiving("get person from provider")
                      .path("/person")
                      .method("GET")
                      .willRespondWith()
                      .status(200)
                      .headers(headers)
                      .body(new PactDslJsonBody().and("name", "Hans")
                                                 .and("age", 11))
                      .toPact();
    }

    @PactVerification
    @Test
    public void firstPactTest() {
        Person actual = underTest.getPersonFromProvider();

        Assert.assertEquals("Hans", actual.getName());
        Assert.assertEquals(11, actual.getAge());
    }
}
