package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.repo.film.FilmRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Получение всех фильмов
 */
@RequestMapping("/films")
@Controller
public class FilmsView {
    private final FilmRepo filmRepo;

    public FilmsView(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping
    public String films(Model model) {

        model.addAttribute("films", filmRepo.findAll());
        return "films";
    }
}
