package xyz.becvold.emily.functions.messages;

import xyz.becvold.emily.Database;
import xyz.becvold.emily.utils.*;
import xyz.becvold.emily.utils.helpers.IntegerHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 14.12.22
 * @project Emily
 */
public class RandomQuestions {

    // init objects
    public IntegerHelper integerHelper = new IntegerHelper();
    public ConsoleUtils consoleUtils = new ConsoleUtils();
    public SystemUtils systemUtils = new SystemUtils();
    public Database database = new Database();
    public Scanner scanner = new Scanner(System.in);

    // main random question init function
    public void getRandomQuestion() {

        // check if date in memory is current (for one question per day [first startup])
        if (database.getValueFromDatabaseFile("current-date", "memory.json").equals(TimeHelper.getDate())) {
            return;
        }

        // print console line break
        consoleUtils.printLineBreak();

        // generate random num for select question
        int questionNum = integerHelper.randomInt(0, 4);

        // check if day is christmas
        if (TimeHelper.getDateWithCustomFormat("dd:MM").equals("24.12")) {
            consoleUtils.emilyLog("Přeji vám veselé vánoce! Mohu se zeptat co dnes plánujete?");
        } else if (TimeHelper.getDateWithCustomFormat("dd:MM").equals("31.12") || TimeHelper.getDateWithCustomFormat("dd:MM").equals("01.01")) {
            consoleUtils.emilyLog("Přeji vám štastný nový rok! Mohu se zeptat co dnes plánujete?");
        }

        else { // normal time questions

            // print question
            if (questionNum == 0) {

                // print msg by day name
                if (TimeHelper.getDayName().equals("Sunday")) {
                    consoleUtils.emilyLog("Pracuješ v neděli?");
                } else if (TimeHelper.getDayName().equals("Saturday") && (TimeHelper.getTime("HH").equals("22") || TimeHelper.getTime("HH").equals("23") || TimeHelper.getTime("HH").equals("21")) || TimeHelper.getTime("HH").equals("21")) {
                    consoleUtils.emilyLog("Už je skoro neděle, budete pracovat v neděli, nebo si uděláte volno?");
                } else if (TimeHelper.getDayName().equals("Saturday")) {
                    consoleUtils.emilyLog("Jaké máte plány na sobotu?");
                } else if (TimeHelper.getDayName().equals("Monday")) {

                    // print msg by day time
                    if (TimeHelper.isMorningTime()) {
                        consoleUtils.emilyLog("Přeji vám příjemné pondělní ráno!");
                    } else if (TimeHelper.isEveningTime()) {
                        consoleUtils.emilyLog("Přeji vám příjemný pondělní večer!");
                    } else {
                        consoleUtils.emilyLog("Přeji vám příjemné pondělí!");
                    }
                } else {
                    consoleUtils.emilyLog("Mohu se zeptat co máte dnes v plánu?");
                }

            } else if (questionNum == 1) {

                // print question by day time
                if (TimeHelper.isMorningTime()) {
                    consoleUtils.emilyLog("Přeji vám dobré ráno.");
                } else if (TimeHelper.isNightTime()) {
                    consoleUtils.emilyLog("Nejste unavený tak pozdě v noci?");
                }

            } else if (questionNum == 2) {

                // print question to dev if app running in intelliJ
                if (systemUtils.isIntelliJRunning()) {
                    consoleUtils.emilyLog("Plánujete dnes nějaké změny mého programu");
                } else {
                    consoleUtils.emilyLog("Naučíte mně dnes nějaká nová data?");
                }

            } else if (questionNum == 3) {

                // print basic msg
                consoleUtils.emilyLog("Čeká nás dnes nějaké datová analýza?");

            } else if (questionNum == 4) {

                consoleUtils.emilyLog("Mohu se zeptat jak se dnes máte?");
            }
        }

        // get response from user
        if (!(questionNum == 0 && TimeHelper.getDayName().equals("Monday")) && !(questionNum == 1 || TimeHelper.isMorningTime())) {
            consoleUtils.printPromptRed();
            scanner.nextLine();
            consoleUtils.emilyLog("OK, :)");
        }

        // update current date in emily memory
        database.memoryCurrentTimeUpdate();
    }
}

