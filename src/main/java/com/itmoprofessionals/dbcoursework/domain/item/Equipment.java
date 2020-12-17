package com.itmoprofessionals.dbcoursework.domain.item;

import com.itmoprofessionals.dbcoursework.domain.employee.role.ScriptWriter;
import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Equipment {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    private BigDecimal price;
    private String type;
    private String model;
    private String name;

    @ManyToMany(mappedBy = "equipmentList")
    private List<ScriptWriter> scriptWriter;

    @OneToOne
    private Size size;

    // relatives

    @OneToMany
    private List<Occupation> occupationList;

}
