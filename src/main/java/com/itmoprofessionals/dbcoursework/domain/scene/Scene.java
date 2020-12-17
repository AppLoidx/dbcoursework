package com.itmoprofessionals.dbcoursework.domain.scene;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
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

    @OneToOne
    private Film film;

    @ManyToOne
    private Scene scene;

    // mapped relatives

    @OneToMany(mappedBy = "scene")
    private List<Occupation> occupationList;

    @OneToOne
    private Schedule schedule;
}
