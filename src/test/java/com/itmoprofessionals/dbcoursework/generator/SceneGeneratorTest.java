package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SceneGeneratorTest {
    @Test
    public void sceneGenerator() {
        Scene scene = SceneGenerator.generateScene(randomFilm(), 0);

        assertNotNull(scene);
        assertNotNull(scene.getName());
        assertNotNull(scene.getSceneOrder());
        assertNotNull(scene.getDescription());
        assertNotNull(scene.getFilm());
    }

    @Test
    public void sceneGeneratorWithAmount() {
        List<Scene> sceneList = SceneGenerator.generateScenes(randomFilm(), 10);
        assertEquals(10, sceneList.size());
    }

    private Film randomFilm() {
        return FilmGenerator.generateFilm(
                CompanyGenerator.createCompany(),
                PersonalGenerator.generatePersonalFor(
                        EmployeeGenerator.generate(20)
                )
        );
    }
}