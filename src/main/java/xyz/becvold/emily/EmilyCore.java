package xyz.becvold.emily;

import xyz.becvold.emily.functions.actions.EmergencyShutdown;
import xyz.becvold.emily.functions.reactions.Greeting;
import xyz.becvold.emily.utils.StringUtils;
import xyz.becvold.emily.utils.ConsoleUtils;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class EmilyCore {

    // instances initiate
    public ConsoleUtils console = new ConsoleUtils();
    public Scanner scanner = new Scanner(System.in);

    // instances of functions
    public Greeting greeting = new Greeting();
    public EmergencyShutdown emergencyShutdown = new EmergencyShutdown();

    // core function
    public void init() throws InterruptedException {

        // print prompt line
        console.printPrompt();

        // get user input
        String input = scanner.nextLine();

        // check if input not empty
        if (input.isEmpty()) {
            console.emilyLog("Cože? Tvá zpráva je prázdná!");
        } else {

            // validate input
            input = StringUtils.validateInput(input);

            // process reaction /////////////////////////////////////////////////////////

            // emergency shutdown
            if (emergencyShutdown.isShutdownInit(input)) {
                emergencyShutdown.emergencyShutdown();
            }

            // greeting
            else if (greeting.isGreeting(input)) {
                greeting.getOutput(input);

            } else {
                // not found input msg
                console.emilyLog("Omlouvám se ale nerozuměla jsem vám :(");
            }
            /////////////////////////////////////////////////////////////////////////////
        }

        // reinit this function
        init();
    }
}
