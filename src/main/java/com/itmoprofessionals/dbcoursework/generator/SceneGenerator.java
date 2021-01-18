package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.item.Prop;
import com.itmoprofessionals.dbcoursework.domain.scene.Place;
import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import com.itmoprofessionals.dbcoursework.domain.scene.Schedule;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class SceneGenerator {

    private static final Faker faker = new Faker();

    private SceneGenerator() {
    }


    public static Scene generateScene(Film film, int sceneOrder) {
        return Scene.builder()
                .name(faker.book().title())
                .description(faker.shakespeare().hamletQuote())
                .sceneOrder(sceneOrder)
                .film(film)
                .schedule(new Schedule(DateTime.now().plusHours(sceneOrder + 1).toDate(), DateTime.now().plusHours(sceneOrder + faker.random().nextInt(2, 48)).toDate()))
                .build();
    }

    public static List<Scene> generateScenes(Film film, int amount) {
        List<Scene> scenes = new ArrayList<>();
        List<Place> placeList = new ArrayList<>();
        placeList.add(Place
                .builder()
                .address(faker.address().fullAddress())
                .country(faker.country().name())
                .description(faker.lorem().sentence())
                .name(faker.elderScrolls().region())
                .city(faker.address().city())
                .build());
        for (int sceneOrder = 0; sceneOrder < amount; sceneOrder++) {
            Scene scene = Scene.builder()
                    .name(faker.book().title())
                    .description(faker.shakespeare().kingRichardIIIQuote())
                    .sceneOrder(sceneOrder)
                    .film(film)
                    .place(placeList)
                    .schedule(new Schedule(DateTime.now().plusHours(sceneOrder + 1).toDate(), DateTime.now().plusHours(sceneOrder + 2).toDate()))
                    .build();

            List<Prop> collect = IntStream.range(0, faker.random().nextInt(2))
                    .mapToObj(n -> PropGenerator.createProp(scene))
                    .collect(Collectors.toList());


            scenes.add(scene);

        }

        return scenes;

    }
}
