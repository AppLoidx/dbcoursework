package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.employee.role.Producer;
import com.itmoprofessionals.dbcoursework.domain.film.Prediction;
import org.joda.time.DateTime;

import java.util.Date;

public final class PredictionGenerator {
    private static final Faker faker = new Faker();
    private PredictionGenerator() {}

    public static Prediction createPrediction(Producer producer) {

        return Prediction.builder()
                .film(producer.getFilm())
                .createdDate(new Date())
                .description("That's my prediction!")
                .predictedBy(producer)
                .predictedDate(DateTime.now().plusWeeks(faker.random().nextInt(12)).toDate())
                .build();

    }
}
