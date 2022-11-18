package xyz.becvold.emily.output.messages;

import xyz.becvold.emily.utils.console.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class Greeting {

    // init objects
    public static ConsoleUtils console = new ConsoleUtils();

    public static boolean isGreeting(String input) {
        if (input.equals("ahoj")) {
            return true;
        } else if (input.equals("čus")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void getOutput(String input) {
        console.emilyLog("čau");
    }
}
