package com.itmoprofessionals.dbcoursework.repo;

import com.itmoprofessionals.dbcoursework.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepo extends JpaRepository<Company, UUID> {
}
