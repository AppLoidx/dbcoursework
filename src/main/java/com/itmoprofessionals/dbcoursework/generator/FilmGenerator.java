package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.film.Film;

public final class FilmGenerator {

    private static final Faker faker = new Faker();

    private FilmGenerator() {
    }

    public static Film generateFilm(Company company, Personal personal) {
        Film film = Film.builder()
                .name(randomFilmName())
                .company(company)
                .synopsis(DescriptionGenerator.generateDescription())
                .build();

        company.getFilms().add(film);

        personal.getActorList().forEach(a -> {
            a.setFilm(film);
            a.setContract(ContractGenerator.createContract(company, a, film));
        });

        personal.getCameramanList().forEach(c -> {
            c.setFilm(film);
            c.setContract(ContractGenerator.createContract(company, c, film));
        });

        personal.getDirectorList().forEach(d -> {
            d.setFilm(film);
            d.setContract(ContractGenerator.createContract(company, d, film));
        });

        personal.getProducerList().forEach(p -> {
            p.setFilm(film);
            p.setContract(ContractGenerator.createContract(company, p, film));
            p.getPredictions().add(PredictionGenerator.createPrediction(p));
        });

        personal.getScriptWriterList().forEach(sw -> {
            sw.setFilm(film);
            sw.setContract(ContractGenerator.createContract(company, sw, film));
        });

        film.setActorList(personal.getActorList());
        film.setCameramanList(personal.getCameramanList());
        film.setDirectorList(personal.getDirectorList());
        film.setProducerList(personal.getProducerList());
        film.setScriptWriterList(personal.getScriptWriterList());
        return film;
    }

    public static String randomFilmName() {
        return faker.elderScrolls().creature();
    }
}
