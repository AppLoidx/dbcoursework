package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.repo.film.FilmRepo;
import com.itmoprofessionals.dbcoursework.util.IdUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/film/{film-uuid}")
public class FilmView {

    private final FilmRepo filmRepo;

    public FilmView(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping
    public String film(
            @PathVariable("film-uuid") String filmUUID,
            Model model
    ) {
        Optional<Film> optionalFilm = filmRepo.findById(IdUtil.parse(filmUUID));

        if (optionalFilm.isPresent()) {
            model.addAttribute("film", optionalFilm.get());
            return "film";
        } else {
            return "error";
        }
    }
}
