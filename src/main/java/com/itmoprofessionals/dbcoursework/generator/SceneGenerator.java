package com.itmoprofessionals.dbcoursework.generator;

import com.github.javafaker.Faker;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import com.itmoprofessionals.dbcoursework.domain.scene.Schedule;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public final class SceneGenerator {

    private static final Faker faker = new Faker();

    private SceneGenerator() {
    }

    ;

    public static Scene generateScene(Film film, int sceneOrder) {
        return Scene.builder()
                .name(faker.elderScrolls().region())
                .description(faker.elderScrolls().city())
                .sceneOrder(sceneOrder)
                .film(film)
                .schedule(new Schedule(DateTime.now().plusHours(sceneOrder + 1).toDate(), DateTime.now().plusHours(sceneOrder + 2).toDate()))
                .build();
    }

    public static List<Scene> generateScenes(Film film, int amount) {
        List<Scene> scenes = new ArrayList<>();
        for (int sceneOrder = 0; sceneOrder < amount; sceneOrder++) {
            Scene scene = Scene.builder()
                    .name(faker.elderScrolls().region())
                    .description(faker.elderScrolls().city())
                    .sceneOrder(sceneOrder)
                    .film(film)
                    .schedule(new Schedule(DateTime.now().plusHours(sceneOrder + 1).toDate(), DateTime.now().plusHours(sceneOrder + 2).toDate()))
                    .build();

            scenes.add(scene);
        }

        return scenes;

    }
}
