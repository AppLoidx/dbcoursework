package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.employee.Contract;
import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import org.joda.time.DateTime;

import java.util.Date;

public final class ContractGenerator {
    private static final Faker faker = new Faker();
    private ContractGenerator() {}

    public static Contract createContract(Company company, EmployeeRole employeeRole) {
        Contract contract = Contract
                .builder()
                .name("Document-" + faker.number().digit())
                .company(company)
                .description(faker.lorem().sentence())
                .docUrl("http://www.orimi.com/pdf-test.pdf")
                .endDate(DateTime.now().plusYears(1).toDate())
                .interrupted(false)
                .printed(false)
                .createdDate(new Date())
                .build();

        if (employeeRole instanceof Actor) {
            contract.setActor((Actor) employeeRole);
        } else if (employeeRole instanceof Cameraman) {
            contract.setCameraman((Cameraman) employeeRole);
        } else if (employeeRole instanceof Director) {
            contract.setDirector((Director) employeeRole);
        } else if (employeeRole instanceof Producer) {
            contract.setProducer((Producer) employeeRole);
        } else if (employeeRole instanceof ScriptWriter) {
            contract.setScriptWriter((ScriptWriter) employeeRole);
        }

        return contract;
    }
}
