package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.item.Prop;
import com.itmoprofessionals.dbcoursework.domain.item.Size;
import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

public final class PropGenerator {
    private static final Faker faker = new Faker();
    private PropGenerator() {}

    public static Prop createProp(Scene scene) {
        return Prop
                .builder()
                .name(faker.funnyName().name())
                .occupationList(List.of(Occupation.builder()
                        .occupationStart(DateTime.now().plusDays(2 + faker.random().nextInt(5)).toDate())
                        .occupationEnd(DateTime.now().plusDays(2 + faker.random().nextInt(5, 10)).toDate())
                        .scene(scene)
                        .build()))
                .price(BigDecimal.valueOf(faker.random().nextInt(1000, 100_000)))
                .size(Size.of(faker.random().nextInt(1000), faker.random().nextInt(1000), faker.random().nextInt(1000)))
                .type(faker.app().name())
                .build();
    }
}
