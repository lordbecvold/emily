package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.helpers.StringHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 19.12.22
 * @project Emily
 */
public class WhoIsYourCreatorResponse {
    // usages count
    private int usages = 0;

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();
    public final StringHelper stringHelper = new StringHelper();

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
            "kdo je tvůj tvůrce",
            "kdo tě vytvořil",
            "kdo tě napsal",
            "kdo tě stvořil",
            "kdo tě vytvořil",
            "vytvořil tě kdo",
            "stvořil tě kdo",
            "napsal tě kdo",
            "tvůj tvůtce je",
            "kdo tě naprogramoval",
            "kdo tě nakodoval",
            "kdo tě nacodoval",
            "kdo je tvůj dev",
            "kdo je tvůj programátor",

            // other langs
            "who is your creator",
            "who is your dev",
            "who dev you",
            "who created"
    );

    private void use(String input) {
        // check if overused eng
        if (input.contains(stringHelper.validateInput("who is you creator")) || input.contains(stringHelper.validateInput("who is your dev")) || input.contains(stringHelper.validateInput("who dev you")) || input.contains(stringHelper.validateInput("who created"))) {
            console.emilyLog("My developer is Lukáš Bečvář(Lordbecvold) http://becvold.xyz/");
        } else {
            console.emilyLog("Můj developer je Lukáš Bečvář(Lordbecvold) http://becvold.xyz/");
        }
    }

    private void overused(String input) {
        // check if overused eng
        if (input.contains(stringHelper.validateInput("who is you creator")) || input.contains(stringHelper.validateInput("who is your dev")) || input.contains(stringHelper.validateInput("who dev you")) || input.contains(stringHelper.validateInput("who created"))) {
            console.emilyLog("I already told you this.");
        } else {
            console.emilyLog("Nebudu znovu odpovídat po desáté.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}
