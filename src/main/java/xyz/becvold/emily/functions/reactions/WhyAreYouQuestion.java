package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 24.11.22
 * @project Emily
 */
public class WhyAreYouQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // check if why are you executed
    public boolean isExecute(String input) {
        if (input.contains("procjsi")) {
            return true;
        } else if (input.contains("procsi")) {
            return true;
        } else if (input.contains("nacojsi")) {
            return true;
        } else if (input.contains("nacosi")) {
            return true;
        } else if (input.contains("cemujsi")) {
            return true;
        } else if (input.contains("whyareyou")) {
            return true;
        } else if (input.contains("whyyou")) {
            return true;
        } else if (input.contains("procexistujes")) {
            return true;
        } else if (input.contains("nacoexistujes")) {
            return true;
        } else if (input.contains("duvoduexistujes")) {
            return true;
        } else {
            return false;
        }
    }

    // excuted why are you output
    public void onExecute(String input) {

        // check if question si overused
        if (usages > 8) {
            if (input.contains("whyareyou")) {
                console.emilyLog("I already told you this.");
            } else if (input.contains("whyyou")) {
                console.emilyLog("I already told you this.");
            } else {
                console.emilyLog("Nebudu znovu odpovídat.");
            }
        } else {
            if (input.contains("whyareyou")) {
                console.emilyLog("I am here for you and for your comfort.");
            } else if (input.contains("whyyou")) {
                console.emilyLog("I am here for you and for your comfort.");
            } else {
                console.emilyLog("jsem tu pro vás a pro vaš pohodlí.");
            }
        }

        // set usages + 1
        usages++;
    }
}
