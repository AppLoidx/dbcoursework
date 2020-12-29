package com.itmoprofessionals.dbcoursework.repo.employee;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {
}
