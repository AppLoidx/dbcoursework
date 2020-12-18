package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonalGeneratorTest {


    @Test
    public void generatePersonal() {
        final int employeesAmount = 50;
        Personal personal = PersonalGenerator.generatePersonalFor(EmployeeGenerator.generate(employeesAmount));

        assertNotNull(personal.getActorList());
        assertNotNull(personal.getCameramanList());
        assertNotNull(personal.getDirectorList());
        assertNotNull(personal.getProducerList());
        assertNotNull(personal.getScriptWriterList());

        int amountAllRoles = personal.getActorList().size() + personal.getCameramanList().size()
                + personal.getDirectorList().size() + personal.getProducerList().size()
                + personal.getScriptWriterList().size();
        assertEquals(employeesAmount, amountAllRoles);

    }


}