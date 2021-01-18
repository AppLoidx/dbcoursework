package com.itmoprofessionals.dbcoursework.dto;

import com.itmoprofessionals.dbcoursework.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDto {
    private String name;

    private String businessType;

    private String managerLegalName;

    private Long bik;

    private Long inn;

    private Long ogrn;

    public CompanyDto(Company company) {
        this.name = company.getName();
        this.businessType = company.getBusinessType();
        this.managerLegalName = company.getManagerLegalName();
        this.bik = company.getBik();
        this.inn = company.getInn();
        this.ogrn = company.getOgrn();
    }
}
