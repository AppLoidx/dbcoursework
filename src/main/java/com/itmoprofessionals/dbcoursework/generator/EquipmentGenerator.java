package com.itmoprofessionals.dbcoursework.generator;


import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.item.Equipment;
import com.itmoprofessionals.dbcoursework.domain.item.Size;

import java.math.BigDecimal;

public final class EquipmentGenerator {
    private static final Faker faker = new Faker();

    private EquipmentGenerator() {}

    public static Equipment createEquipment() {
        return Equipment
                .builder()
                .model(faker.commerce().promotionCode())
                .name(faker.commerce().productName())
                .size(Size.of(
                        faker.random().nextInt(0, 1000),
                        faker.random().nextInt(0, 1000),
                        faker.random().nextInt(0, 1000)
                ))
                .price(BigDecimal.valueOf(faker.random().nextInt(1000, 100_000)))
                .type(faker.commerce().material())
                .build();

    }
}
