package com.itmoprofessionals.dbcoursework.domain.film;

import com.itmoprofessionals.dbcoursework.domain.employee.role.Producer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Prediction {
    @Id
    @GeneratedValue
    private UUID id;

    private Date predictedDate;
    private Date createdDate;
    private String description;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Producer predictedBy;
}
