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
    private PersonalGenerator() {}


    public static Personal generatePersonalFor(List<Employee> employees) {
        Personal personal = new Personal();


        for (Employee employee : employees) {

            Equipment equipment = EquipmentGenerator.createEquipment();
            Occupation occupation = Occupation
                    .builder()
                    .occupationStart(DateTime.now().toDate())
                    .occupationEnd(DateTime.now().plusHours(12).toDate())
                    .build();

            equipment.getOccupationList().add(occupation);

            switch (random.nextInt(5)) {
                case 0:
                    Actor actor = new Actor();
                    actor.getEquipmentList().add(equipment);
                    actor.setEmployee(employee);
                    employee.getActorList().add(actor);
                    personal.getActorList().add(actor);
                    break;
                case 1:
                    Cameraman cameraman = new Cameraman();
                    cameraman.getEquipmentList().add(equipment);
                    cameraman.setEmployee(employee);
                    employee.getCameramanList().add(cameraman);
                    personal.getCameramanList().add(cameraman);
                    break;
                case 2:
                    Director director = new Director();
                    director.getEquipmentList().add(equipment);
                    director.setEmployee(employee);
                    employee.getDirectorList().add(director);
                    personal.getDirectorList().add(director);
                    break;
                case 3:
                    Producer producer = new Producer();
                    producer.setEmployee(employee);
                    employee.getProducerList().add(producer);
                    personal.getProducerList().add(producer);
                    break;
                case 4:
                    ScriptWriter scriptWriter = new ScriptWriter();
                    scriptWriter.setEmployee(employee);
                    employee.getScriptWriterList().add(scriptWriter);
                    personal.getScriptWriterList().add(scriptWriter);
                    break;
            }
        }

        return personal;

    }

    private static String randomRole() {
        return random.nextInt(2) == 0 ? "Main role" : "Second role";
    }
}
