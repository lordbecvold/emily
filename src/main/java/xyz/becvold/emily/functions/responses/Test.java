package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.ArraysHelper;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.TimeUtils;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class Test {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public ArraysHelper arraysHelper = new ArraysHelper();

    // init function
    public void execute(String input) {

        // reset usages if is new day
        if (!Main.currentDate.equals(TimeUtils.getDate())) {
            Main.currentDate = TimeUtils.getDate();
            usages = 0;
            console.log("reset");
        }

        // create final input array
        List finalInputs = arraysHelper.createFinalInputList(inputsList);

        // check if input found in array
        if (arraysHelper.inputContainsElement(finalInputs, input)) {

            // check if function is overused
            if (usages < maxUsagesCount) {
                use(input);
            } else {
                overused(input);
            }

            // set usages + 1
            usages++;

            // set input found + 1 (for core function)
            Main.inputFound++;
        }
    }

    // MAIN FUNCTION SKELETON /////////////////////////////////////////////////////////////////////
    public int maxUsagesCount = 10;

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "test"
    );

    public void use(String input) {
        console.emilyLog("test OK!");
    }

    public void overused(String input) {
        console.emilyLog("test is overused!");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}