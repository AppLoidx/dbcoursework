package com.itmoprofessionals.dbcoursework.domain.employee.role;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Cameraman extends EmployeeRole {
    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cameraman cameraman = (Cameraman) o;
        return Objects.equals(id, cameraman.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
