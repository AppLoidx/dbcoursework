package com.itmoprofessionals.dbcoursework.domain.employee;

import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // fields

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(columnDefinition = "text")
    private String biography;

    // relatives

    @Builder.Default
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<EmployeeDocs> docs = new ArrayList<>();


    // mapped relatives

    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Experience> experienceList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Actor> actorList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Cameraman> cameramanList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Director> directorList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Producer> producerList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ScriptWriter> scriptWriterList = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts = new ArrayList<>();

    public String fullName() {
        return name + " " + surname;
    }

    public String simpleBirthDate() {
        return new DateTime(this.birthDate).toString("dd/MM/YYYY");
    }


}
