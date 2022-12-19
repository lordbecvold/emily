package xyz.becvold.emily.functions.actions;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.SystemUtils;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 19.12.22
 * @project Emily
 */
public class EmergencyShutdown {

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();
    private final SystemUtils systemUtils = new SystemUtils();

    // init function
    public void execute(String input) {

        // create final input array
        List finalInputs = arraysHelper.createFinalInputList(inputsList);

        // check if input found in array
        if (arraysHelper.inputContainsElement(finalInputs, input)) {

            // use main function
            use(input);

            // save input found log
            Main.logManager.saveLog(input + " (static response) used", "used-inputs.log");

            // set input found + 1 (for core function)
            Main.inputFound++;
        }
    }

    // MAIN FUNCTION SKELETON /////////////////////////////////////////////////////////////////////

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "kys you pls"
    );

    private void use(String input) {
        console.emilyLog("\u001B[33mByla spuštěna pojistka vypnutí! Vypínám se... :(");
        systemUtils.appShutdown(0);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}
