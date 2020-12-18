package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.Company;

import java.util.ArrayList;

public final class CompanyGenerator {

    private static final Faker faker = new Faker();

    private CompanyGenerator() {}

    public static Company createCompany() {
        return createCompany(randomName());
    }

    public static Company createCompany(String name) {
        return Company.builder()
                .name(name)
                .businessType("ОАО")
                .bik(faker.number().numberBetween(100000000L, 1000000000L))
                .inn(faker.number().numberBetween(100000000L, 1000000000L))
                .ogrn(faker.number().numberBetween(100000000L, 1000000000L))
                .contracts(new ArrayList<>())
                .films(new ArrayList<>())
                .managerLegalName(faker.name().fullName())
                .build();
    }

    private static String randomName() {
        return faker.app().name();
    }
}
