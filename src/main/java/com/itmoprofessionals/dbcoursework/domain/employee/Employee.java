package com.itmoprofessionals.dbcoursework.domain.employee;

import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Employee   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // fields

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(columnDefinition = "text")
    private String biography;

    // relatives

    @OneToMany(mappedBy = "owner")
    private List<EmployeeDocs> docs;


    // mapped relatives

    @OneToMany(mappedBy = "employee")
    private List<Experience> experienceList;

    @OneToMany(mappedBy = "employee")
    private List<Actor> actorList;

    @OneToMany(mappedBy = "employee")
    private List<Cameraman> cameramanList;

    @OneToMany(mappedBy = "employee")
    private List<Director> directorList;

    @OneToMany(mappedBy = "employee")
    private List<Producer> producerList;

    @OneToMany(mappedBy = "employee")
    private List<ScriptWriter> scriptWriterList;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;

}
