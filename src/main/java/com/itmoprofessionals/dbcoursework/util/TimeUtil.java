package com.itmoprofessionals.dbcoursework.util;

import org.joda.time.DateTime;

import java.util.Date;

public final class TimeUtil {
    private TimeUtil(){}

    public static String prettify(Date date) {
        DateTime dt = new DateTime(date);
        return dt.toString("dd/MM/yyyy HH:mm");
    }
}
