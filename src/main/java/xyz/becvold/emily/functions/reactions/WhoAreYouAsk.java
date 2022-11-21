package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class WhoAreYouAsk {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // check if who are you used
    public boolean isWhoAreYouAsked(String input) {
        if (input.contains("kdo jsi")) {
            return true;
        } else if (input.contains("kdo si")) {
            return true;
        } else if (input.contains("who are you")) {
            return true;
        } else if (input.contains("what's your name")) {
            return true;
        } else if (input.contains("jak se jmenujes")) {
            return true;
        } else if (input.contains("jak se menujes")) {
            return true;
        } else if (input.contains("jake je tvoje jmeno")) {
            return true;
        } else if (input.contains("jake je tvoje meno")) {  
            return true;  
        } else if (input.contains("tvoje jmeno")) {
            return true;
        } else if (input.contains("tve jmeno")) {
            return true;
        } else if (input.contains("tvoje meno")) {
            return true;
        } else if (input.contains("tve meno")) {
            return true;
        } else if (input.contains("co jsi")) {
            return true;
        } else if (input.contains("co si")) {
            return true;
        } else {
            return false;
        }
    }

    // print who are you
    public void sayWhoAreYou(String input) {

        // check if usags is overloaded
        if (usages > 8) {

            // print overloaded message
            if (input.contains("who are you") || input.contains("what's your name")) {
                console.emilyLog("I already answered that.");
            } else {
                console.emilyLog("Na to jsem už odpověděla.");
            }

        } else {

            // print valid return
            if (input.contains("who are you")) {
                console.emilyLog("I'm Emily, an Artificial Intelligence designed to converse and control a computer's operating system.");
            } else if (input.contains("what's your name")) {
                console.emilyLog("My name is emily.");

            } else if (input.contains("jak se jmenujes") || input.contains("jak se menujes") || input.contains("jake je tvoje jmeno") || input.contains("jake je tvoje meno") || input.contains("tvoje jmeno") || input.contains("tve jmeno") || input.contains("tvoje meno") || input.contains("tve meno")) {
                console.emilyLog("Mé jméno je Emily.");
            } else {
                console.emilyLog("Jsem Emily, Umělá inteligence navržená ke konverzaci, a ovládání operačního systému počítače.");
            }
        }

        // set usages + 1
        usages++;
    }
}
