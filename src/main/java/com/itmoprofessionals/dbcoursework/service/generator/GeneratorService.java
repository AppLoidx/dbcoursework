package com.itmoprofessionals.dbcoursework.service.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.generator.*;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.repo.item.PropRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GeneratorService {

    private final CompanyRepo companyRepo;
    private final PropRepo propRepo;
    private final Faker faker = new Faker();
    public GeneratorService(CompanyRepo companyRepo, PropRepo propRepo) {
        this.companyRepo = companyRepo;
        this.propRepo = propRepo;
    }


    public void generateData() {
        log.info("Start sql script");
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            log.info("Creating company...");
            companyList.add(createCompany());
        }

        log.info("Created companies : " + companyList.size());
        int totalFilms = companyList.stream().map(c -> c.getFilms().size()).reduce(Integer::sum).orElse(0);
        log.info("Total films : " + totalFilms);
    }

    @Transactional
    public Company createCompany() {
        Company company = CompanyGenerator.createCompany();
        for (int i = 0; i < faker.random().nextInt(3, 5); i++) {
            generateFilm(company);
        }

        return companyRepo.save(company);
    }

    private void generateFilm(Company company) {
        Film film = FilmGenerator.generateFilm(
                company,
                PersonalGenerator.generatePersonalFor(EmployeeGenerator.generate(50))
        );

        film.getSceneList().addAll(SceneGenerator.generateScenes(film, 100));

    }
}
