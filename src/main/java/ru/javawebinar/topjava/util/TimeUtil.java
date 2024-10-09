package ru.javawebinar.topjava.util;

import java.time.LocalTime;

public class TimeUtil {
    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        boolean startsOk = (startTime == null || lt.compareTo(startTime) >= 0);
        boolean endsOk = (endTime == null || lt.compareTo(endTime) < 0);
        return startsOk && endsOk;
    }
}
