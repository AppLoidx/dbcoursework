package com.itmoprofessionals.dbcoursework.domain.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Size {
    @Id
    @GeneratedValue
    private UUID id;

    private double x;
    private double y;
    private double z;

    public static Size of(double x, double y, double z) {
        Size size = new Size();
        size.setX(x);
        size.setY(y);
        size.setZ(z);

        return size;
    }

    @Override
    public String toString() {
        return String.format("%.2fx%.2fx%.2f", x, y, z);
    }
}
