package com.itmoprofessionals.dbcoursework.domain.scene;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private UUID id;

    private Date startTime;
    private Date endTime;

    @OneToOne(mappedBy = "schedule")
    private Scene scene;

    public Schedule(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
