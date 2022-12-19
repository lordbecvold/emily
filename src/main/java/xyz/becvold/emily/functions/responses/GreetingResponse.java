package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.*;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.helpers.IntegerHelper;
import xyz.becvold.emily.utils.helpers.StringHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class GreetingResponse {

    // usages count
    private int usages = 0;

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();
    private final StringHelper stringHelper = new StringHelper();
    private final IntegerHelper integerHelper = new IntegerHelper();

    // init function
    public void execute(String input) {

        // reset usages if is new day
        if (!Main.currentDate.equals(TimeHelper.getDate())) {
            Main.currentDate = TimeHelper.getDate();
            usages = 0;
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
    private final int maxUsagesCount = 15;

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "ahoj",
            "čus",
            "čau",
            "zdravím",
            "zdravím vás",
            "nazdar",
            "zdar",
            "nazdárek",
            "čusík",
            "zdarec",
            "ahojda",
            "čauky",
            "dobrý den",
            "dobrý večer",
            "dobré odpoledne",
            "dobré ráno",
            "dobrý podvečer",
            "dobré poledne",
            "dobré dopoledne",
            "servus",
            "cc",
            "cs",
            "caw",
            "cav",

            // other langs
            "hello",
            "hi",
            "guten tag",
            "hallo"
    );

    private void use(String input) {

        if (input.contains(stringHelper.validateInput("dobrý den"))) {
            if (!TimeHelper.isNightTime() || TimeHelper.isEveningTime()) {
                console.emilyLog("Dobrý den, přeji.");
            } else {
                console.emilyLog("Není den, ale dobrý i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobrý večer"))) {
            if (TimeHelper.isEveningTime()) {
                console.emilyLog("Dobrý večer i vám.");
            } else {
                console.emilyLog("Není večer, ale dobrý i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobré odpoledne"))) {
            if (TimeHelper.isAafternoonTime()) {
                console.emilyLog("Dobré odpoledne i vám.");
            } else {
                console.emilyLog("Není odpoledne, ale dobré i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobré ráno"))) {
            if (TimeHelper.isMorningTime()) {
                console.emilyLog("Dobré ráno i vám.");
            } else {
                console.emilyLog("Jako není ráno, ale dobré i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobrý podvečer"))) {
            if (TimeHelper.isEarlyEveningTime()) {
                console.emilyLog("Dobrý podvečer i vám.");
            } else {
                console.emilyLog("No... není sice podvečer, ale dobrý i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobré poledne"))) {
            if (TimeHelper.isNoonTime()) {
                console.emilyLog("Dobré poledne i vám.");
            } else {
                console.emilyLog("No.. není sice poledne, ale dobré i vám.");
            }

        } else if (input.contains(stringHelper.validateInput("dobré dopoledne"))) {
            if (TimeHelper.isAfterMorningTime()) {
                console.emilyLog("Dobré dopoledne, přeji.");
            } else {
                console.emilyLog("Sice není dopoledne, ale dobré i vám.");
            }
        } else if (input.contains("hello")) {
            console.emilyLog("Hello!");

        } else if (input.contains("hi")) {
            console.emilyLog("Hi!");

        } else if (input.contains(stringHelper.validateInput("guten tag"))) {
            console.emilyLog("Hallo!");

        } else if (input.contains("hallo")) {
            console.emilyLog("Hallo!");

        } else if (input.contains("servus")) {
            console.emilyLog("No servus člověče!");

        } else if (input.contains("cc")) {
            console.emilyLog("cs no...");

        } else if (input.contains("cs")) {
            console.emilyLog("cc");

        } else if (input.contains(stringHelper.validateInput("čau"))) {
            console.emilyLog("Čau čau čau čau čau čau čau čáááu buzeranti!");

        } else if (input.contains("caw") || input.contains("cav")) {
            console.emilyLog("Cawwwww bráško!");

        } else {
            console.emilyLog("Zdravím tě.");
        }
    }

    private void overused(String input) {
        if (input.contains("hello") || input.contains("hi")) {
            console.emilyLog("We will not repeat ourselves again!");
        } else if (input.contains("hallo") || input.contains(stringHelper.validateInput("guten tag"))) {
            console.emilyLog("Wir werden uns nicht noch einmal wiederholen!");
        } else {
            // generate random number in range
            int randomInt = integerHelper.randomInt(0, 3);

            // print random overused messages
            if (randomInt == 0) {
                console.emilyLog("Promin, ale nebudu tě už znovu zdravit.");
            } else if (randomInt == 1) {
                console.emilyLog("Nebudeme se furt opakovat!");
            } else if (randomInt == 2) {
                console.emilyLog("hele neříkej to furt dokola.");
            } else {
                console.emilyLog("Tak snad jsme se už pozdravili.");
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}