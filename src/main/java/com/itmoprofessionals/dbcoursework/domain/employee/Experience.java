package com.itmoprofessionals.dbcoursework.domain.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Experience {
    @Id
    @GeneratedValue
    private UUID id;


    // fields

    private Date startDate;
    private Date endDate;
    private String role;

    // relatives

    @ManyToOne
    private Employee employee;
}
