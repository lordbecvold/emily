package xyz.becvold.emily.output;

import xyz.becvold.emily.output.messages.Greeting;
import xyz.becvold.emily.utils.console.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class OutputProcesor {

    // init objects
    public ConsoleUtils console = new ConsoleUtils();

    // main output procesor function
    public void outputProces(String input) {

        // greeting
        if (Greeting.isGreeting(input)) {
            Greeting.getOutput(input);

        // not found input
        } else {
            console.emilyLog("Omlouvám se ale nerozuměla jsem vám :(");
        }
    }
}
