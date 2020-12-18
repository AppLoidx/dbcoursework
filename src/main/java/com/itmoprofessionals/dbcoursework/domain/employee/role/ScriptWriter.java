package com.itmoprofessionals.dbcoursework.domain.employee.role;

import com.itmoprofessionals.dbcoursework.domain.item.Equipment;
import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class ScriptWriter extends EmployeeRole {
    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptWriter cameraman = (ScriptWriter) o;
        return Objects.equals(id, cameraman.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
