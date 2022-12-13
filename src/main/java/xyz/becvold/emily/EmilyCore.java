package xyz.becvold.emily;

import xyz.becvold.emily.functions.responses.*;
import xyz.becvold.emily.utils.StringUtils;
import xyz.becvold.emily.utils.ConsoleUtils;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class EmilyCore {

    // instances initiate
    public ConsoleUtils console = new ConsoleUtils();
    public Scanner scanner = new Scanner(System.in);
    public StringUtils stringUtils = new StringUtils();
    public Database database = new Database();

    // instances of functions
    public Test test = new Test();

    // core function
    public void init() throws UnknownHostException {

        // set default input found value
        Main.inputFound = 0;

        // print prompt line
        console.printPrompt();

        // get user input
        String input = scanner.nextLine();

        // save raw input
        String inputRaw = input;

        // process reaction ///////////////////////////////////////////////////////////////////////

        // check if input not empty
        if (input.isEmpty()) {
            console.emilyLog("Cože? Tvá zpráva je prázdná!");
        } else {

            // validate input
            input = stringUtils.validateInput(input);

            // RESPONSES FUNCTIONS LIST /////////////////////////////////////////////////
            test.execute(input);
            /////////////////////////////////////////////////////////////////////////////

            // check if input found
            if (Main.inputFound == 0) {

                // check if input found in database
                if (database.isValueExistInDatabase(input, "database.json")) {

                    // print response from database
                    console.emilyLog(database.getValueFromDatabaseFile(input, "database.json"));

                    // save input found log
                    Main.logManager.saveLog(inputRaw + " used and found in database", "used-inputs.log");

                } else {

                    // save not found input to log file
                    Main.logManager.saveLog(inputRaw, "not-found-inputs.log");

                    // print not found msg
                    console.emilyLog("Omlouvám se ale nerozuměla jsem vám :(");
                }
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////

        // reinit this function
        init();
    }
}
