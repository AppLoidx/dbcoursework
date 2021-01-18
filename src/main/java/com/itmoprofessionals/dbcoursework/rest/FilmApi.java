package com.itmoprofessionals.dbcoursework.rest;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.dto.FilmDto;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.repo.film.FilmRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/film")
public class FilmApi {
    private final FilmRepo filmRepo;
    private final CompanyRepo companyRepo;

    public FilmApi(FilmRepo filmRepo, CompanyRepo companyRepo) {
        this.filmRepo = filmRepo;
        this.companyRepo = companyRepo;
    }

    @PostMapping
    public ResponseEntity<?> createFilm(FilmDto filmDto) {
        Film film = Film.builder()
                .name(filmDto.getName())
                .synopsis(filmDto.getSynopsis())
                .company(companyRepo.findById(filmDto.getCompanyId()).get())
                .build();
        filmRepo.saveAndFlush(film);

        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/film/" + film.getId().toString())
                .build();
    }
}
