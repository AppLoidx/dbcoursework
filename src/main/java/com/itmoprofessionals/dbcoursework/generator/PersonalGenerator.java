package com.itmoprofessionals.dbcoursework.generator;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import com.itmoprofessionals.dbcoursework.domain.employee.role.*;
import com.itmoprofessionals.dbcoursework.domain.item.Equipment;
import com.itmoprofessionals.dbcoursework.domain.scene.Occupation;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Random;

public final class PersonalGenerator {
    private static final Random random = new Random();

    private PersonalGenerator() {
    }


    public static Personal generatePersonalFor(List<Employee> employees) {
        Personal personal = new Personal();

        boolean directorCreated = false;
        boolean producerCreated = false;
        int scriptWriterAmount = Math.min(Math.max(employees.size() - 2, 0), 2);
        int cameramanAmount = Math.min(Math.max(employees.size() - 2 - scriptWriterAmount, 0), 4);

        for (Employee employee : employees) {

            Equipment equipment = EquipmentGenerator.createEquipment();
            Occupation occupation = Occupation
                    .builder()
                    .occupationStart(DateTime.now().toDate())
                    .occupationEnd(DateTime.now().plusHours(12).toDate())
                    .build();

            equipment.getOccupationList().add(occupation);
            if (!directorCreated) {
                Director director = new Director();
                director.getEquipmentList().add(equipment);
                director.setEmployee(employee);
                employee.getDirectorList().add(director);
                personal.getDirectorList().add(director);
                directorCreated = true;
                continue;
            }

            if (!producerCreated) {
                Producer producer = new Producer();
                producer.setEmployee(employee);
                employee.getProducerList().add(producer);
                personal.getProducerList().add(producer);
                producerCreated = true;
                continue;
            }


            if (scriptWriterAmount-- > 0) {
                ScriptWriter scriptWriter = new ScriptWriter();
                scriptWriter.setEmployee(employee);
                employee.getScriptWriterList().add(scriptWriter);
                personal.getScriptWriterList().add(scriptWriter);
                scriptWriterAmount--;
                continue;
            }

            if (cameramanAmount-- > 0) {
                Cameraman cameraman = new Cameraman();
                cameraman.getEquipmentList().add(equipment);
                cameraman.setEmployee(employee);
                employee.getCameramanList().add(cameraman);
                personal.getCameramanList().add(cameraman);
                continue;
            }

            Actor actor = new Actor();
            actor.getEquipmentList().add(equipment);
            actor.setEmployee(employee);
            employee.getActorList().add(actor);
            personal.getActorList().add(actor);

        }

        return personal;

    }

    private static String randomRole() {
        return random.nextInt(2) == 0 ? "Main role" : "Second role";
    }
}
