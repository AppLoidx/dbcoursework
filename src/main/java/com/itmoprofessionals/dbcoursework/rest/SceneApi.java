package com.itmoprofessionals.dbcoursework.rest;

import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import com.itmoprofessionals.dbcoursework.domain.scene.Schedule;
import com.itmoprofessionals.dbcoursework.repo.film.FilmRepo;
import com.itmoprofessionals.dbcoursework.repo.scene.SceneRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/scene")
public class SceneApi {
    private final SceneRepo sceneRepo;
    private final FilmRepo filmRepo;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SceneApi(SceneRepo sceneRepo, FilmRepo filmRepo) {
        this.sceneRepo = sceneRepo;
        this.filmRepo = filmRepo;
    }

    @PostMapping
    public ResponseEntity<?> createScene(@ModelAttribute SceneDto sceneDto) throws ParseException {
        Scene scene = Scene.builder()
                .sceneOrder(sceneDto.getSceneOrder())
                .name(sceneDto.getName())
                .description(sceneDto.getDescription())
                .film(filmRepo.getOne(UUID.fromString(sceneDto.getFilm())))
                .schedule(new Schedule(sdf.parse(sceneDto.startDate), sdf.parse(sceneDto.endDate)))
                .build();

        sceneRepo.saveAndFlush(scene);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "/scene/" + scene.getId().toString())
                .build();

    }

    @Data
    @NoArgsConstructor
    private static class SceneDto {
        private Integer sceneOrder;
        private String name;
        private String description;
        private String film;
        private String startDate;
        private String endDate;

    }
}
