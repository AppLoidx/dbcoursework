package com.itmoprofessionals.dbcoursework.service.business.impl;

import com.itmoprofessionals.dbcoursework.dto.CompanyDto;
import com.itmoprofessionals.dbcoursework.repo.CompanyRepo;
import com.itmoprofessionals.dbcoursework.service.business.CompanyService;
import com.itmoprofessionals.dbcoursework.domain.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public Company createCompany(CompanyDto companyDto) {
        Company company = Company.builder()
                .name(companyDto.getName())
                .inn(companyDto.getInn())
                .ogrn(companyDto.getOgrn())
                .bik(companyDto.getBik())
                .businessType(companyDto.getBusinessType())
                .managerLegalName(companyDto.getManagerLegalName())
                .build();

        return companyRepo.saveAndFlush(company);
    }
}
