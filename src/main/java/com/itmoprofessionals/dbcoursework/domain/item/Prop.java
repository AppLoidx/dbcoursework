package com.itmoprofessionals.dbcoursework.domain.item;

import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prop {
    @GeneratedValue
    @Id
    private UUID id;

    // fields

    private String type;
    private String name;
    private BigDecimal price;

    // relatives

    @OneToOne(cascade = CascadeType.ALL)
    private Size size;

    @OneToMany
    private List<Occupation> occupationList;
}
