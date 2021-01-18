package com.itmoprofessionals.dbcoursework.domain.scene;

import com.itmoprofessionals.dbcoursework.util.TimeUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Date startTime;
    @Column(nullable = false)
    private Date endTime;

    @OneToOne(mappedBy = "schedule")
    private Scene scene;

    public Schedule(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String prettyStartTime() {
        return TimeUtil.prettify(startTime);
    }

    public String prettyEndTime() {
        return TimeUtil.prettify(endTime);
    }
}
