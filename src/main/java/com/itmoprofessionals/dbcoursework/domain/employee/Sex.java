package com.itmoprofessionals.dbcoursework.domain.employee;

public enum Sex {
    MALE {
        @Override
        public String simpleName() {
            return "муж";
        }
    },

    FEMALE {
        @Override
        public String simpleName() {
            return "жен";
        }
    };

    public abstract String simpleName();
}
