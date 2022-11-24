package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Lukáš Bečvář on 24.11.22
 * @project Emily
 */
public class WhereAreYouQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // check if where are you question executed
    public boolean isExecute(String input) {

        if (input.contains("kdejsi")) {
            return true;
        } else if (input.contains("kdesi")) {
            return true;
        } else if (input.contains("whereyou")) {
            return true;
        } else if (input.contains("whereareyou")) {
            return true;
        } else if (input.contains("kdeyou")) {
            return true;
        } else if (input.contains("wherejsi")) {
            return true;
        } else if (input.contains("wheresi")) {
            return true;
        } else if (input.contains("kamjsisla")) {
            return true;
        } else if (input.contains("kamsisla")) {
            return true;
        } else if (input.contains("kamsisel")) {
            return true;
        } else if (input.contains("kamjsisel")) {
            return true;
        } else {
            return false;
        }
    }

    // execute valid output
    public void onExecute(String input) throws UnknownHostException {

        String hostname = InetAddress.getLocalHost().getHostName();

        // check if question si overused
        if (usages > 8) {
            if (input.contains("whereyou")) {
                console.emilyLog("I already told you this.");
            } else if (input.contains("wherejsi")) {
                console.emilyLog("I already told you this.");
            } else if (input.contains("wheresi")) {
                console.emilyLog("I already told you this.");
            } else if (input.contains("whereareyou")) {
                console.emilyLog("I already told you this.");
            } else {
                console.emilyLog("Nebudu znovu odpovídat.");
            }

        } else {
            if (input.contains("whereyou")) {
                console.emilyLog("I'm on a computer called: " + hostname);
            } else if (input.contains("wherejsi")) {
                console.emilyLog("I'm on a computer called: " + hostname);
            } else if (input.contains("wheresi")) {
                console.emilyLog("I'm on a computer called: " + hostname);
            } else if (input.contains("whereareyou")) {
                console.emilyLog("I'm on a computer called: " + hostname);
            } else {
                console.emilyLog("Jsem na počítači s názvem: " + hostname);
            }
        }

        // set usages + 1
        usages++;
    }
}
