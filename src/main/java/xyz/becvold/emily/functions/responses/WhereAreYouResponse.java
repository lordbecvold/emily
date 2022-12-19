package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.helpers.StringHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 19.12.22
 * @project Emily
 */
public class WhereAreYouResponse {

    // usages count
    private int usages = 0;

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();
    private final StringHelper stringHelper = new StringHelper();

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
                try {
                    use(input);
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }

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
            "kde jsi",
            "kde si",
            "kde you",
            "where jsi",
            "where si",
            "kam jsi šla",
            "kam si šla",
            "kam si šel",
            "kam jsiěel",

            // other langs
            "where you",
            "where are you"
    );

    private void use(String input) throws UnknownHostException {

        String hostname = InetAddress.getLocalHost().getHostName();

        if (input.contains(stringHelper.validateInput("where you"))) {
            console.emilyLog("I'm on a computer called: " + hostname);
        } else if (input.contains(stringHelper.validateInput("where jsi"))) {
            console.emilyLog("I'm on a computer called: " + hostname);
        } else if (input.contains(stringHelper.validateInput("where si"))) {
            console.emilyLog("I'm on a computer called: " + hostname);
        } else if (input.contains(stringHelper.validateInput("where are you"))) {
            console.emilyLog("I'm on a computer called: " + hostname);
        } else {
            console.emilyLog("Jsem na počítači s názvem: " + hostname);
        }
    }

    private void overused(String input) {
        if (input.contains(stringHelper.validateInput("where you"))) {
            console.emilyLog("I already told you this.");
        } else if (input.contains(stringHelper.validateInput("where jsi"))) {
            console.emilyLog("I already told you this.");
        } else if (input.contains(stringHelper.validateInput("where si"))) {
            console.emilyLog("I already told you this.");
        } else if (input.contains(stringHelper.validateInput("where are you"))) {
            console.emilyLog("I already told you this.");
        } else {
            console.emilyLog("Nebudu znovu odpovídat.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}
