package com.itmoprofessionals.dbcoursework.util;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public final class IdUtil {
    private IdUtil(){}

    public static UUID parse(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException exp) {
            log.error("Invalid value to UUID parser", exp);
            return null;
        }
    }
}
