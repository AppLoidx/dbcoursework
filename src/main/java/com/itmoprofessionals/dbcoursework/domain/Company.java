package com.itmoprofessionals.dbcoursework.domain;

import com.itmoprofessionals.dbcoursework.domain.employee.Contract;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue
    private UUID id;

    // Fields

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String businessType;

    @Column(nullable = false)
    private String managerLegalName;

    @Column(nullable = false)
    private Long bik;

    @Column(nullable = false)
    private Long inn;

    @Column(nullable = false)
    private Long ogrn;


    // Relatives

    // Mapped relatives

    @OneToMany(mappedBy = "company")
    private List<Film> films;

    @OneToMany(mappedBy = "company")
    private List<Contract> contracts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
