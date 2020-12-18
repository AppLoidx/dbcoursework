package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Personal {
    private List<Actor> actorList = new ArrayList<>();
    private List<Cameraman> cameramanList = new ArrayList<>();
    private List<Director> directorList = new ArrayList<>();
    private List<Producer> producerList = new ArrayList<>();
    private List<ScriptWriter> scriptWriterList = new ArrayList<>();
}
