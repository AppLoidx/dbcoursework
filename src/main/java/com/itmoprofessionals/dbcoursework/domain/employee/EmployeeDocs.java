package com.itmoprofessionals.dbcoursework.domain.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class EmployeeDocs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int workBookId;

    // fields

    @Column(nullable = false)
    private int documentId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @ManyToOne
    private Employee owner;
}
