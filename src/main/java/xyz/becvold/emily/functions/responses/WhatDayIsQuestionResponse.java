package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class WhatDayIsQuestionResponse {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public ArraysHelper arraysHelper = new ArraysHelper();
    public StringUtils stringUtils = new StringUtils();
    public IntUtils intUtils = new IntUtils();

    // init function
    public void execute(String input) {

        // reset usages if is new day
        if (!Main.currentDate.equals(TimeUtils.getDate())) {
            Main.currentDate = TimeUtils.getDate();
            usages = 0;
            console.log("reset");
        }

        // create final input array
        List finalInputs = arraysHelper.createFinalInputList(inputsList);

        // check if input found in array
        if (arraysHelper.inputContainsElement(finalInputs, input)) {

            // check if function is overused
            if (usages < maxUsagesCount) {
                use(input);

                // save input found log
                Main.logManager.saveLog(input + " (static response) used", "used-inputs.log");

            } else {
                overused(input);

                // save input found log
                Main.logManager.saveLog(input + " (static response) overused", "overused-inputs.log");
            }

            // set usages + 1
            usages++;

            // set input found + 1 (for core function)
            Main.inputFound++;
        }
    }

    // MAIN FUNCTION SKELETON /////////////////////////////////////////////////////////////////////
    public int maxUsagesCount = 15;

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "co je za den",
            "jaký je den",
            "který je den",
            "co je dnes",
            "jakej je den",
            "kterej je den",
            "co za den",
            "kterej den",
            "který je den",
            "jakej den",
            "co je",
            "what day"
    );

    public void use(String input) {

        if (input.contains(stringUtils.validateInput("what day"))) {
            console.emilyLog("Today is: " + TimeUtils.getDayName() + ", " + TimeUtils.getDate());
        } else {
            console.emilyLog("Dnes je: " + translateDayName(TimeUtils.getDayName()) + ", " + TimeUtils.getDate());
        }
    }

    public void overused(String input) {
        if (input.contains(stringUtils.validateInput("what day"))) {
            console.emilyLog("I already told you this.");
        } else {
            console.emilyLog("To už jsem ti řekla!");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
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