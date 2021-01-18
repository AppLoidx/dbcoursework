package com.itmoprofessionals.dbcoursework.rest;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import com.itmoprofessionals.dbcoursework.domain.employee.Sex;
import com.itmoprofessionals.dbcoursework.repo.employee.EmployeeRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@Slf4j
public class EmployeeApi {
    private final EmployeeRepo employeeRepo;
    DateTimeFormatter fmt = DateTimeFormat.forPattern("DD/MM/YYYY");


    public EmployeeApi(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/api/v1/employee")
    public ResponseEntity<?> createEmployee(@ModelAttribute EmployeeDto employeeDto) throws ParseException {
        log.info(employeeDto.birthDate);
        Employee employee = Employee.builder()
                .name(employeeDto.name)
                .surname(employeeDto.surname)
                .birthDate(new SimpleDateFormat("dd/MM/yyyy").parse(employeeDto.birthDate))
                .sex(employeeDto.sex)
                .biography(employeeDto.biography)
                .build();

        employeeRepo.saveAndFlush(employee);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "/employee/" + employee.getId().toString())
                .build();

    }

    @NoArgsConstructor
    @Data
    private static class EmployeeDto {
        private String name;
        private String surname;
        private String birthDate;
        private Sex sex;
        private String biography;
    }
}
