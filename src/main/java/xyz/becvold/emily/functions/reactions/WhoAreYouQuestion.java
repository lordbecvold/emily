package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class WhoAreYouQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // check if who are you executed
    public boolean isExecute(String input) {
        if (input.contains("kdojsi")) {
            return true;
        } else if (input.contains("kdosi")) {
            return true;
        } else if (input.contains("whoareyou")) {
            return true;
        } else if (input.contains("what'syourname")) {
            return true;
        } else if (input.contains("jaksejmenujes")) {
            return true;
        } else if (input.contains("jaksemenujes")) {
            return true;
        } else if (input.contains("jakejetvojejmeno")) {
            return true;
        } else if (input.contains("jakejetvojemeno")) {
            return true;  
        } else if (input.contains("tvojejmeno")) {
            return true;
        } else if (input.contains("tvejmeno")) {
            return true;
        } else if (input.contains("tvojemeno")) {
            return true;
        } else if (input.contains("tvemeno")) {
            return true;
        } else if (input.contains("cojsi")) {
            return true;
        } else if (input.contains("cosi")) {
            return true;
        } else if (input.contains("kdojste")) {
            return true;
        } else if (input.contains("procjste")) {
            return true;
        } else if (input.contains("jaksejmenujete")) {
            return true;
        } else {
            return false;
        }
    }

    // check if input what's your name in czech
    public boolean isWhatsName(String input) {
        if (input.contains("jaksejmenujes")) {
            return true;
        } else if (input.contains("jaksemenujes")) {
            return true;
        } else if (input.contains("jakejetvojejmeno")) {
            return true;
        } else if (input.contains("jakejetvojemeno")) {
            return true;
        } else if (input.contains("tvojejmeno")) {
            return true;
        } else if (input.contains("tvejmeno")) {
            return true;
        } else if (input.contains("tvemeno")) {
            return true;
        } else {
            return false;
        }
    }

    // execute who are you output
    public void onExecute(String input) {

        // check if usags is overused
        if (usages > 8) {

            // print overused message
            if (input.contains("whoareyou") || input.contains("what'syourname")) {
                console.emilyLog("I already answered that.");
            } else {
                console.emilyLog("Na to jsem už odpověděla.");
            }

        } else {

            // print valid return
            if (input.contains("whoareyou")) {
                console.emilyLog("I'm Emily, an Artificial Intelligence designed to converse and control a computer's operating system.");
            } else if (input.contains("what'syourname")) {
                console.emilyLog("My name is emily.");

            } else if (isWhatsName(input)) {
                console.emilyLog("Mé jméno je Emily.");
            } else {
                console.emilyLog("Jsem Emily, Umělá inteligence navržená ke konverzaci, a ovládání operačního systému počítače.");
            }
        }

        // set usages + 1
        usages++;
    }
}
