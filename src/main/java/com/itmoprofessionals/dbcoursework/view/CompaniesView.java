package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class CompaniesView {

    private final CompanyRepo companyRepo;

    public CompaniesView(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @GetMapping
    public String companiesTemplate(Model model) {
        model.addAttribute("companies", companyRepo.findAll());

        return "companies";
    }
}
