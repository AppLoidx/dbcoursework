package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.employee.role.Actor;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmGeneratorTest {
    @Test
    public void filmGenerate() {
        Personal personal = PersonalGenerator.generatePersonalFor(EmployeeGenerator.generate(50));
        Company company = CompanyGenerator.createCompany();
        Film film = FilmGenerator.generateFilm(company, personal);

        assertNotNull(film);
        assertNotNull(film.getCompany());
        assertNotNull(film.getName());
        assertNotNull(film.getSynopsis());
        assertTrue(company.getFilms().contains(film));

        for (Actor actor : personal.getActorList()) {
            assertNotNull(actor.getFilm());
        }

        // no time for tests!
    }
}