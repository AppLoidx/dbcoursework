package com.itmoprofessionals.dbcoursework.domain.employee.role;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.employee.Contract;
import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import com.itmoprofessionals.dbcoursework.domain.item.Equipment;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Data
public abstract class EmployeeRole {
    @ManyToOne
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Equipment> equipmentList = new ArrayList<>();

}
