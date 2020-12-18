package com.itmoprofessionals.dbcoursework.domain.scene;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    // mapped relatives

    @ManyToMany(mappedBy = "place")
    private List<Scene> sceneList;
}
