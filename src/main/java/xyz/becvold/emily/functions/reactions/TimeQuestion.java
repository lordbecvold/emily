package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.IntUtils;
import xyz.becvold.emily.utils.TimeUtils;

/**
 * @author Lukáš Bečvář on 22.11.22
 * @project Emily
 */
public class TimeQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public IntUtils intUtils = new IntUtils();

    // check if time executed
    public boolean isExecute(String input) {
        if (input.contains("kolikjehodin")) {
            return true;
        } else if (input.contains("kolikje")) {
            return true;
        } else if (input.contains("whattime")) {
            return true;
        } else if (input.contains("kolikhodin")) {
            return true;
        } else if (input.contains("cojezadeniobdobi")) {
            return true;
        } else if (input.contains("cojezaobdobidne")) {
            return true;
        } else if (input.contains("kdyje")) {
            return true;
        } else if (input.contains("kolkoje")) {
            return true;
        } else if (input.contains("kolkohodinje")) {
            return true;
        } else if (input.contains("kolkojehodin")) {
            return true;
        } else if (input.contains("kolikjest")) {
            return true;
        } else if (input.contains("cojezacastdne")) {
            return true;
        } else if (input.contains("jakajecastden")) {
            return true;
        } else if (input.contains("jakacastdneje")) {
            return true;
        } else if (input.contains("castdnejejaka")) {
            return true;
        } else if (input.contains("kteracastdneje")) {
            return true;
        } else if (input.contains("kterjecastdne")) {
            return true;
        } else if (input.contains("jakyjecas")) {
            return true;
        } else if (input.contains("cojezacas")) {
            return true;
        } else {
            return false;
        }
    }

    // execute time output
    public void onExecute(String input) {

        // check if overused
        if (usages > 30) {

            // lang check
            if (input.contains("whattime")) {
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

        } else {
            // lang check
            if (input.contains("whattime")) {
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

        // set usags +1
        usages++;
    }
}
