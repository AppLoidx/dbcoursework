package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/company/{company-uuid}")
public class CompanyView {
    private final CompanyRepo companyRepo;

    public CompanyView(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @GetMapping
    public String companyById(@PathVariable("company-uuid") String companyUuid,
                              Model model, ModelAndView modelAndView) {
        log.info("Company view [GET]");
        // TODO: create exception controller
        Optional<Company> optionalCompany = companyRepo.findById(IdUtil.parse(companyUuid));

        if (optionalCompany.isPresent()) {

            Company company =  optionalCompany.get();
            model.addAttribute("company", company);
            return "company";

        } else {
            log.info("Company is not found");
            modelAndView.setStatus(HttpStatus.BAD_REQUEST);
            return "error";
        }

    }
}
