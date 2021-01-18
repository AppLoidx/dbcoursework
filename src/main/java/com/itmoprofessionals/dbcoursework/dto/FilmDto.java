package com.itmoprofessionals.dbcoursework.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
public class FilmDto {
    private String name;

    private String synopsis;
    private UUID companyId;
}
