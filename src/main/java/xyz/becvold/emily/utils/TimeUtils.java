package xyz.becvold.emily.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class TimeUtils {

    // get actual time in string
    public static int getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
        LocalDateTime now = LocalDateTime.now();
        return Integer.parseInt(dtf.format(now));
    }

    // check of time is morning
    public static boolean isMorningTime() {
        if (getTime() == 5) {
            return true;
        } else if (getTime() == 6) {
            return true;
        } else if (getTime() == 7) {
            return true;
        } else if (getTime() == 8) {
            return true;
        } else if (getTime() == 9) {
            return true;
        } else {
            return false;
        }
    }

    // check of time is after morning
    public static boolean isAfterMorningTime() {
        if (getTime() == 10) {
            return true;
        } else if (getTime() == 11) {
            return true;
        } else {
            return false;
        }
    }

    // check of time is noon
    public static boolean isNoonTime() {
        if (getTime() == 12) {
            return true;
        } else {
            return false;
        }
    }

    // check of time is early evning
    public static boolean isEarlyEveningTime() {
        if (getTime() == 17) {
            return true;
        } else if (getTime() == 18) {
            return true;
        } else if (getTime() == 19) {
            return true;
        }  else {
            return false;
        }
    }

    // check of time is after noon
    public static boolean isAafternoonTime() {
        if (getTime() == 12) {
            return true;
        } else if (getTime() == 13) {
            return true;
        } else if (getTime() == 14) {
            return true;
        } else if (getTime() == 15) {
            return true;
        } else if (getTime() == 16) {
            return true;
        } else if (getTime() == 17) {
            return true;
        }  else {
            return false;
        }
    }

    // check of time is eeavning
    public static boolean isEveningTime() {
        if (getTime() == 20) {
            return true;
        } else if (getTime() == 21) {
            return true;
        } else if (getTime() == 22) {
            return true;
        } else if (getTime() == 23) {
            return true;
        } else {
            return false;
        }
    }

    // check of time is night
    public static boolean isNightTime() {
        if (getTime() == 0) {
            return true;
        } else if (getTime() == 1) {
            return true;
        } else if (getTime() == 2) {
            return true;
        } else if (getTime() == 3) {
            return true;
        } else if (getTime() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
