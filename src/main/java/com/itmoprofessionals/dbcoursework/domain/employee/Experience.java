package com.itmoprofessionals.dbcoursework.domain.employee;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

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

    public static Experience random(Employee employee) {
        Faker faker = new Faker();
        Experience experience = new Experience();
        experience.employee = employee;
        experience.role = faker.random().nextInt(0, 1) == 0 ? "main" : "second";
        experience.startDate = faker.date().between(
                DateTime.now().minusYears(4).toDate(),
                DateTime.now().minusYears(3).toDate()
        );
        experience.endDate = faker.date().between(
                DateTime.now().minusYears(2).toDate(),
                DateTime.now().toDate()
        );

        return experience;
    }
}
