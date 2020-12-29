package com.itmoprofessionals.dbcoursework.domain.employee;

import com.itmoprofessionals.dbcoursework.domain.Company;
import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import com.itmoprofessionals.dbcoursework.domain.film.Film;
import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@ToString(exclude = {"employee", "company", "cameraman", "actor", "director", "producer", "scriptWriter"})
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "active_cameraman",
                procedureName = "active_cameraman",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = Void.class)
                }
        )
)
public class Contract {
    @Type(type="pg-uuid")
    @Id
    @GeneratedValue
    private UUID id;

    // fields

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

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

    @ManyToOne(cascade = CascadeType.ALL)
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

    @ManyToOne
    private Film film;


    public String simpleCreatedDate() {
        return new DateTime(this.createdDate).toString("dd/MM/YYYY", new Locale("RU"));
    }

    public String simpleEndDate() {
        return new DateTime(this.endDate).toString("dd/MM/YYYY", new Locale("RU"));
    }

    public RoleName getRoleName() {
        if (actor != null) return RoleName.from(actor.getClass());
        else if (cameraman != null) return RoleName.from(cameraman.getClass());
        else if (director != null) return RoleName.from(director.getClass());
        else if (producer != null) return RoleName.from(producer.getClass());
        else if (scriptWriter != null) return RoleName.from(scriptWriter.getClass());
        else return RoleName.OTHER;
    }
}
