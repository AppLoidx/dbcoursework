package com.itmoprofessionals.dbcoursework.domain.film;


import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false, columnDefinition = "text")
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String synopsis;

    // relatives

    @ManyToOne
    private Company company;

    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Scene> sceneList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Actor> actorList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Cameraman> cameramanList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Director> directorList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Producer> producerList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<ScriptWriter> scriptWriterList = new ArrayList<>();


}
