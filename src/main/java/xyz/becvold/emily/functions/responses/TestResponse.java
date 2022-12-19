package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class TestResponse {

    // usages count
    private int usages = 0;

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();

    // init function
    public void execute(String input) {

        // reset usages if is new day
        if (!Main.currentDate.equals(TimeHelper.getDate())) {
            Main.currentDate = TimeHelper.getDate();
            usages = 0;
        }

        // create final input array
        List finalInputs = arraysHelper.createFinalInputList(inputsList);

        // check if input found in array
        if (arraysHelper.inputContainsElement(finalInputs, input)) {

            // check if function is overused
            if (usages < maxUsagesCount) {
                use(input);

                // save input found log
                Main.logManager.saveLog(input + " (static response) used", "used-inputs.log");

            } else {
                overused(input);

                // save input found log
                Main.logManager.saveLog(input + " (static response) overused", "overused-inputs.log");
            }

            // set usages + 1
            usages++;

            // set input found + 1 (for core function)
            Main.inputFound++;
        }
    }

    // MAIN FUNCTION SKELETON /////////////////////////////////////////////////////////////////////
    private final int maxUsagesCount = 10;

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "test 1",
            "test 2",
            "test"
    );

    private void use(String input) {
        console.emilyLog(input + " OK!");
    }

    private void overused(String input) {
        console.emilyLog(input + " is overused!");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}