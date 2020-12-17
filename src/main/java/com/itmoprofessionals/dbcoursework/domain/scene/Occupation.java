package com.itmoprofessionals.dbcoursework.domain.scene;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Occupation {
    @GeneratedValue
    @Id
    private UUID id;

    private Date occupationStart;
    private Date occupationEnd;

    @ManyToOne
    private Scene scene;
}
