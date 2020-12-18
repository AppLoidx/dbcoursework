package com.itmoprofessionals.dbcoursework.service.generator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class FakerService {
    private Faker faker;

    void init() {
        faker = new Faker();
    }

    public String fakeName() {
        return faker.name().fullName();
    }
}
