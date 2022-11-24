package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.TimeUtils;

/**
 * @author Lukáš Bečvář on 22.11.22
 * @project Emily
 */
public class WhatDayIsQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // check if day ask executed
    public boolean isWhatDayAsk(String input) {
        if (input.contains("cojezaden")) {
            return true;
        } else if (input.contains("jakyjeden")) {
            return true;
        } else if (input.contains("whatday")) {
            return true;
        } else if (input.contains("kterýjeden")) {
            return true;
        } else if (input.contains("cojednes")) {
            return true;
        } else if (input.contains("jakejjeden")) {
            return true;
        } else if (input.contains("kterejjeden")) {
            return true;
        } else if (input.contains("cozaden")) {
            return true;
        } else if (input.contains("kterejden")) {
            return true;
        } else if (input.contains("kteryjeden")) {
            return true;
        } else if (input.contains("jakejden")) {
            return true;
        } else if (input.contains("coje")) {
            return true;
        } else {
            return false;
        }
    }

    // what day output
    public void whatDayAnswer(String input) {

        // lang check
        if (input.contains("whatday")) {

            // check if is overused
            if (usages > 20) {
                console.emilyLog("I already told you this.");
            } else  {
                console.emilyLog("Today is: " + TimeUtils.getDayName() + ", " + TimeUtils.getDate());
            }
        } else {

            // check if is overused
            if (usages > 20) {
                console.emilyLog("To už jsem ti řekla!");
            } else  {

                // check if funny msg
                if (input.contains("coje")) {
                    console.emilyLog("Je " + translateDayName(TimeUtils.getDayName()) + " lmao :)");
                } else {
                    console.emilyLog("Dnes je: " + translateDayName(TimeUtils.getDayName()) + ", " + TimeUtils.getDate());
                }
            }

        }

        // set usages +1
        usages++;
    }

    // translate day name
    public String translateDayName(String dayName) {
        if (dayName.equalsIgnoreCase("Sunday")) {
            return "neděle";
        } else if (dayName.equalsIgnoreCase("Monday")) {
            return "pondělí";
        } else if (dayName.equalsIgnoreCase("Tuesday")) {
            return "úterý";
        } else if (dayName.equalsIgnoreCase("Wednesday")) {
            return "středa";
        } else if (dayName.equalsIgnoreCase("Thursday")) {
            return "čtvrtek";
        } else if (dayName.equalsIgnoreCase("Friday")) {
            return "pátek";
        } else if (dayName.equalsIgnoreCase("Saturday")) {
            return "sobota";
        } else {
            return "non";
        }
    }
}
