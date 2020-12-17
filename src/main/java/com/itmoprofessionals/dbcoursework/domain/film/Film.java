package com.itmoprofessionals.dbcoursework.domain.film;


import com.itmoprofessionals.dbcoursework.domain.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Film {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String synopsis;

    // relatives

    @ManyToOne
    private Company company;

}
