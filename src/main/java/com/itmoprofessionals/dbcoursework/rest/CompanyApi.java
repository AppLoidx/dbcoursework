package com.itmoprofessionals.dbcoursework.rest;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.dto.CompanyDto;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.service.business.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/company")
@Slf4j
public class CompanyApi {
    private final CompanyService companyService;
    private final CompanyRepo companyRepo;

    public CompanyApi(CompanyService companyService, CompanyRepo companyRepo) {
        this.companyService = companyService;
        this.companyRepo = companyRepo;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        return ResponseEntity.ok(companyRepo.findAll()
                .stream()
                .map(CompanyDto::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@ModelAttribute CompanyDto companyDto) {
        log.info("Creating company");
        Company company = companyService.createCompany(companyDto);
        log.info("Company created");
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/company/" + company.getId().toString()).build();
    }

}
