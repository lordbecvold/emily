package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.StringHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class WhoAreYouResponse {

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
            "kdo jsi",
            "kdo si",
            "jak se jmenuješ",
            "jak se menuješ",
            "jaké je tvoje jméno",
            "jaé je tvoje méno",
            "tvoje jméno",
            "tvé jméno",
            "tvoje méno",
            "tvé méno",
            "co jsi",
            "co si",
            "kdo jste",
            "proč jste",
            "jak se jmenujete",

            // other langs
            "what's your name",
            "who are you"
    );

    // check if input what's your name in czech
    public boolean isWhatsName(String input) {
        if (input.contains(stringHelper.validateInput("jak se jmenuješ"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("jak se menuješ"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("jaké je tvoje jméno"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("jaké je tvoje méno"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("tvoje jméno"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("tvej méno"))) {
            return true;
        } else if (input.contains(stringHelper.validateInput("tvé méno"))) {
            return true;
        } else {
            return false;
        }
    }

    private void use(String input) {
        if (input.contains(stringHelper.validateInput("who are you"))) {
            console.emilyLog("I'm Emily, an Artificial Intelligence designed to converse and control a computer's operating system.");
        } else if (input.contains(stringHelper.validateInput("what's your name"))) {
            console.emilyLog("My name is emily.");

        } else if (isWhatsName(input)) {
            console.emilyLog("Mé jméno je Emily.");
        } else {
            console.emilyLog("Jsem Emily, Umělá inteligence navržená ke konverzaci, a ovládání operačního systému počítače.");
        }
    }

    private void overused(String input) {
        if (input.contains(stringHelper.validateInput("who are you")) || input.contains(stringHelper.validateInput("what's your name"))) {
            console.emilyLog("I already answered that.");
        } else {
            console.emilyLog("Na to jsem už odpověděla.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}