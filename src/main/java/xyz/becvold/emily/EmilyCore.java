package xyz.becvold.emily;

import xyz.becvold.emily.output.OutputProcesor;
import xyz.becvold.emily.utils.StringUtils;
import xyz.becvold.emily.utils.console.ConsoleUtils;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class EmilyCore {

    // objects initiate
    public ConsoleUtils console = new ConsoleUtils();
    public Scanner scanner = new Scanner(System.in);
    public OutputProcesor procesor = new OutputProcesor();

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

            // process output
            procesor.outputProces(validateInput(input));
        }

        // reinit this function
        init();
    }

    public String validateInput(String input) {

        // replace special chars
        input = StringUtils.unaccent(input);

        // replace all to lower case
        input = input.toLowerCase();

        // return valid input
        return input;
    }
}
