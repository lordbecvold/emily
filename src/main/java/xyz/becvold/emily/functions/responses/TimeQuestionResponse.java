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
public class TimeQuestionResponse {

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
            "kolik je hodin",
            "kolik je",
            "kolik hodin",
            "co je za dení období",
            "co je za období dne",
            "kdy je",
            "kolko je",
            "kolko hodin je",
            "kolko je hodin",
            "kolik jest",
            "co je za část dne",
            "jaká je část den",
            "jaká část dne je",
            "část dne je jaká",
            "který část dne je",
            "která je část dne",
            "jaký je čas",
            "co je za čas",

            // other langs
            "what time"
    );

    public void use(String input) {

        // lang check
        if (input.contains(stringUtils.validateInput("what time"))) {
            console.emilyLog("currently it is: " + TimeUtils.getTime("HH:mm"));
        } else {

            // get day part msg
            if (TimeUtils.isEveningTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je ráno.");
            } else if (TimeUtils.isAfterMorningTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je dopoledne.");
            } else if (TimeUtils.isNoonTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je poledne.");
            } else if (TimeUtils.isAafternoonTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je odpoldne.");
            } else if (TimeUtils.isEarlyEveningTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je podvčer.");
            } else if (TimeUtils.isEveningTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je večer.");
            } else if (TimeUtils.isNightTime()) {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm") + ", je noc.");
            } else {
                console.emilyLog("Aktuálně je: " + TimeUtils.getTime("HH:mm"));
            }
        }
    }

    public void overused(String input) {
        if (input.contains(stringUtils.validateInput("what time"))) {
            console.emilyLog("I already told you this.");
        } else {

            // get random number in range
            int random = intUtils.randomInt(0, 3);

            // return random msg
            if (random == 0) {
                console.emilyLog("Nebudeme se stále opakovat!");
            } else if (random == 1) {
                console.emilyLog("hele neptej se furt dokola.");
            } else if (random == 2) {
                console.emilyLog("Nebudu odpovídat znovu.");
            } else {
                console.emilyLog("Už jsem ti tohle říkala.");
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}