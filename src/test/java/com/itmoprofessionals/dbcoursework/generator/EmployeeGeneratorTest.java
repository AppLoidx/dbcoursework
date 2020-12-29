package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EmployeeGeneratorTest {

    @Test
    public void employeeGenerator() {
        Employee employee = EmployeeGenerator.generate();
        assertNotNull(employee.getName());
        assertNotNull(employee.getSurname());
        assertNotNull(employee.getBirthDate());
        assertNotNull(employee.getBiography());
        assertNotNull(employee.getDocs());
        assertFalse(employee.getDocs().isEmpty());
        assertNotNull(employee.getActorList());
        assertNotNull(employee.getCameramanList());
        assertNotNull(employee.getDirectorList());
        assertNotNull(employee.getProducerList());
        assertNotNull(employee.getScriptWriterList());

    }

    @Test
    public void employeeGeneratorWithAmount() {
        final int amount = 50;
        List<Employee> employeeList = EmployeeGenerator.generate(50);
        assertEquals(amount, employeeList.size());
    }

}