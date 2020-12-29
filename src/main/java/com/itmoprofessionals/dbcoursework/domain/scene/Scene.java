package com.itmoprofessionals.dbcoursework.domain.scene;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import com.itmoprofessionals.dbcoursework.domain.item.Prop;
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
public class Scene {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false)
    private Integer sceneOrder;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    // relatives

    @ManyToOne
    private Film film;

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Place> place;

    // mapped relatives

    @Builder.Default
    @OneToMany(mappedBy = "scene", cascade = CascadeType.ALL)
    private List<Occupation> occupationList = new ArrayList<>();


}
