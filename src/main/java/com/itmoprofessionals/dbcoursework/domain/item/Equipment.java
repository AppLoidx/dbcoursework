package com.itmoprofessionals.dbcoursework.domain.item;

import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Equipment {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    private BigDecimal price;
    private String type;
    private String model;
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "equipmentList")
    private List<Actor> actorList = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "equipmentList")
    private List<Cameraman> cameramanList = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "equipmentList")
    private List<Director> directorList = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "equipmentList")
    private List<Producer> producerList = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "equipmentList")
    private List<ScriptWriter> scriptWriterList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Size size;

    // relatives

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    private List<Occupation> occupationList = new ArrayList<>();

}
