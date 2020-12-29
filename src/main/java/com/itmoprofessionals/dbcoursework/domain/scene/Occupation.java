package com.itmoprofessionals.dbcoursework.domain.scene;

import com.itmoprofessionals.dbcoursework.domain.item.Prop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Occupation {
    @GeneratedValue
    @Id
    private UUID id;

    private Date occupationStart;
    private Date occupationEnd;

    @ManyToOne
    private Scene scene;

    @ManyToOne(cascade = CascadeType.ALL)
    private Prop prop;

}
