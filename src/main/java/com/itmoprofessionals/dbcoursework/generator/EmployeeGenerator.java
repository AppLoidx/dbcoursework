package com.itmoprofessionals.dbcoursework.generator;

import antlr.collections.impl.IntRange;
import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.employee.*;
import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class EmployeeGenerator {

    private final static Faker faker = new Faker();

    private EmployeeGenerator() {
    }

    public static Employee generate() {
        Employee employee = Employee.builder()
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .birthDate(faker.date().between(DateTime.now().minusYears(80).toDate(),
                        DateTime.now().minusYears(14).toDate()))
                .biography(DescriptionGenerator.generateDescription())
                .sex(faker.random().nextBoolean() ? Sex.FEMALE : Sex.MALE)
                .build();

        employee.getExperienceList().add(Experience.random(employee));
        employee.getDocs().add(docsGenerator(employee));

        return employee;

    }

    public static List<Employee> generate(int amount) {
        return IntStream
                .range(0, amount)
                .mapToObj(n -> generate())
                .collect(Collectors.toList());
    }

    public static EmployeeDocs docsGenerator(Employee employee) {
        return EmployeeDocs.builder()
                .documentId(faker.number().numberBetween(10000000, 99999999))
                .owner(employee)
                .workBookId(faker.number().numberBetween(10000000, 99999999))
                .documentType(faker.random().nextBoolean() ? DocumentType.PASSPORT : DocumentType.BIRTH_CERTIFICATE)
                .build();
    }
}
