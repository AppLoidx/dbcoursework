package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyGeneratorTest {
    @Test
    public void companyGenerator() {
        Company company = CompanyGenerator.createCompany();
        assertNotNull(company);
        assertNotNull(company.getBik());
        assertNotNull(company.getInn());
        assertNotNull(company.getContracts());
        assertNotNull(company.getBusinessType());
        assertNotNull(company.getFilms());
        assertNotNull(company.getManagerLegalName());
        assertNotNull(company.getName());
        assertNotNull(company.getOgrn());
    }
    @Test
    public void companyGeneratorWithName() {
        final String filmName = "name-kek";
        Company company = CompanyGenerator.createCompany(filmName);
        assertNotNull(company);

        assertEquals(filmName, company.getName());

    }
}