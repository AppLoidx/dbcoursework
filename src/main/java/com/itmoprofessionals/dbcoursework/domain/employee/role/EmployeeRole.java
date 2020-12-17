package com.itmoprofessionals.dbcoursework.domain.employee.role;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.employee.Contract;
import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@Data
public abstract class EmployeeRole {
    @ManyToOne
    private Film film;

    @ManyToOne
    private Employee employee;

    @OneToOne
    private Contract contract;

}
