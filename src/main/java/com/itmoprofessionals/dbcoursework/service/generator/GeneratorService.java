package com.itmoprofessionals.dbcoursework.service.generator;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.generator.CompanyGenerator;
import com.itmoprofessionals.dbcoursework.generator.EmployeeGenerator;
import com.itmoprofessionals.dbcoursework.generator.FilmGenerator;
import com.itmoprofessionals.dbcoursework.generator.PersonalGenerator;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GeneratorService {

    private final CompanyRepo companyRepo;

    public GeneratorService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @PostConstruct
    public void init() {
        Company company = CompanyGenerator.createCompany();
        Film film = FilmGenerator.generateFilm(company, PersonalGenerator.generatePersonalFor(
                EmployeeGenerator.generate(40)
        ));

        companyRepo.save(company);

    }
}
