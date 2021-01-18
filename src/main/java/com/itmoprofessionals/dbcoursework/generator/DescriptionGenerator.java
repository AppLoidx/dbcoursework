package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;

public final class DescriptionGenerator {
    private static final Faker faker = new Faker();
    private DescriptionGenerator() {}

    public static String generateDescription() {
        return faker.shakespeare().romeoAndJulietQuote();
    }
}
