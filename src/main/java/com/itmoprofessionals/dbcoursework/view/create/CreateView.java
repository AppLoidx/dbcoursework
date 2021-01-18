package com.itmoprofessionals.dbcoursework.view.create;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.repo.film.FilmRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/create")
public class CreateView {
    private final CompanyRepo companyRepo;
    private final FilmRepo filmRepo;

    public CreateView(CompanyRepo companyRepo, FilmRepo filmRepo) {
        this.companyRepo = companyRepo;
        this.filmRepo = filmRepo;
    }

    @GetMapping("/company")
    public String companyCreateView() {
        return "create/company";
    }

    @GetMapping("/employee")
    public String employeeCreateView() {
        return "create/employee";
    }

    @GetMapping("/film")
    public String filmCreateView(Model model) {
        Map<UUID, String> companiesMap = new HashMap<>();
        for (Company company : companyRepo.findAll()) {
            companiesMap.put(company.getId(), company.getName());
        }

        model.addAttribute("companies", companiesMap);
        return "create/film";
    }

    @GetMapping("/scene")
    public String sceneCreateView(Model model) {
        Map<UUID, String> filmsMap = new HashMap<>();
        for (Film film : filmRepo.findAll()) {
            filmsMap.put(film.getId(), film.getName());
        }

        model.addAttribute("films", filmsMap);
        return "create/scene";
    }


}
