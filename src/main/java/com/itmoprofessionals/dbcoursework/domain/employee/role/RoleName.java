package com.itmoprofessionals.dbcoursework.domain.employee.role;

public enum RoleName {
    ACTOR {
        @Override
        public String roleName() {
            return "Актер";
        }
    },
    CAMERAMAN {
        @Override
        public String roleName() {
            return "Оператор";
        }
    },
    DIRECTOR {
        @Override
        public String roleName() {
            return "Директор";
        }
    },
    PRODUCER {
        @Override
        public String roleName() {
            return "Продюсер";
        }
    },
    SCRIPT_WRITER {
        @Override
        public String roleName() {
            return "Сценарист";
        }
    },
    OTHER {
        @Override
        public String roleName() {
            return "Другая";
        }
    }
    ;

    public abstract String roleName();
    public static RoleName from(Class<? extends EmployeeRole> clazz) {
        if (clazz == Actor.class) {
            return ACTOR;
        } else if (clazz == Cameraman.class) {
            return CAMERAMAN;
        } else if (clazz == Director.class) {
            return DIRECTOR;
        } else if (clazz == Producer.class) {
            return PRODUCER;
        } else if (clazz == ScriptWriter.class) {
            return SCRIPT_WRITER;
        } else {
            return OTHER;
        }
    }
}
