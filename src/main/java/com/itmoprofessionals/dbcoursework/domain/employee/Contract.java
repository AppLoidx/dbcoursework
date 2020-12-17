package com.itmoprofessionals.dbcoursework.domain.employee;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Contract {
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String  description;

    @Column(nullable = false)
    private String docUrl;

    @Column(nullable = false)
    private boolean printed;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private boolean interrupted;

    // relatives

    @ManyToOne
    private Company company;

    @ManyToOne
    private Employee employee;



    private Date interruptedDate;

    // mapped relatives

    @OneToOne(mappedBy = "contract")
    private Actor actor;

    @OneToOne(mappedBy = "contract")
    private Cameraman cameraman;

    @OneToOne(mappedBy = "contract")
    private Director director;

    @OneToOne(mappedBy = "contract")
    private Producer producer;

    @OneToOne(mappedBy = "contract")
    private ScriptWriter scriptWriter;

}
