package com.itmoprofessionals.dbcoursework.service.business;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.dto.CompanyDto;

public interface CompanyService {
    Company createCompany(CompanyDto companyDto);
}
