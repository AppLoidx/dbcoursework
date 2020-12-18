package com.itmoprofessionals.dbcoursework.domain.employee.role;

import com.itmoprofessionals.dbcoursework.domain.film.Prediction;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Producer extends EmployeeRole {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany
    private List<Prediction> predictions = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer cameraman = (Producer) o;
        return Objects.equals(id, cameraman.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
