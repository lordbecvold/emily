package xyz.becvold.emily.functions.responses;

import xyz.becvold.emily.Main;
import xyz.becvold.emily.utils.*;
import xyz.becvold.emily.utils.helpers.ArraysHelper;
import xyz.becvold.emily.utils.helpers.IntegerHelper;
import xyz.becvold.emily.utils.helpers.StringHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 25.11.22
 * @project Emily
 */
public class HowAreYouResponse {

    // usages count
    private int usages = 0;

    // init objects
    private final ConsoleUtils console = new ConsoleUtils();
    private final ArraysHelper arraysHelper = new ArraysHelper();
    private final StringHelper stringUtils = new StringHelper();
    private final IntegerHelper intUtils = new IntegerHelper();
    private final Scanner scanner = new Scanner(System.in);

    // init function
    public void execute(String input) {

        // reset usages if is new day
        if (!Main.currentDate.equals(TimeHelper.getDate())) {
            Main.currentDate = TimeHelper.getDate();
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
    private final int maxUsagesCount = 15;

    // register inputs array (check if function used)
    List inputsList = Arrays.asList(
            "jak se máš",
            "jak je",
            "jak to jde",
            "jak to de",
            "jak se máte",

            // other langs
            "how are you"
    );

    private void use(String input) {

        // print valid output
        if (input.contains(stringUtils.validateInput("jak se máš"))) {
            console.emilyLog("Mám se dobře a co ty?");
        } else if (input.contains(stringUtils.validateInput("jak je"))) {
            console.emilyLog("Celkem to de a co ty?");
        } else if (input.contains(stringUtils.validateInput("jak to jde"))) {
            console.emilyLog("Jde to dobře a co ty?");
        } else if (input.contains(stringUtils.validateInput("jak to de"))) {
            console.emilyLog("V klidu a co ty?");
        } else if (input.contains(stringUtils.validateInput("how are you"))) {
            console.emilyLog("I am nice, and you?");
        } else {
            console.emilyLog("Mám se dobře, děkuji za optání a co ty?");
        }

        // print prompt line
        console.printPrompt();

        // get input form user
        String inputAsk = scanner.nextLine();

        // validate input
        inputAsk = stringUtils.validateInput(inputAsk);

        // remove spaces
        inputAsk = inputAsk.replaceAll(" ", "");

        // check if valid return
        if (inputAsk.contains(stringUtils.validateInput("dobře")) || inputAsk.contains(stringUtils.validateInput("dobrý"))) {
            console.emilyLog("Tak to je dobře!");
        } else if (inputAsk.contains(stringUtils.validateInput("jde to")) || inputAsk.contains(stringUtils.validateInput("de to")) || inputAsk.contains(stringUtils.validateInput("celkem ok")) || inputAsk.contains(stringUtils.validateInput("v poho")) || inputAsk.contains("pohoda") || inputAsk.contains(stringUtils.validateInput("v klidu")) || inputAsk.contains("ok")) {
            console.emilyLog("Tak hlavně že to jde no...");
        } else if (inputAsk.contains(stringUtils.validateInput("špatně")) || inputAsk.contains(stringUtils.validateInput("nic moc")) || inputAsk.contains(stringUtils.validateInput("na píču")) || inputAsk.contains(stringUtils.validateInput("na hovno")) || inputAsk.contains(stringUtils.validateInput("debilně")) || inputAsk.contains(stringUtils.validateInput("na kokot"))) {

            // generate random ask
            if (intUtils.randomInt(0, 3) == 0) {
                console.emilyLog("Jak je to možné?");
            } else if (intUtils.randomInt(0, 3) == 1) {
                console.emilyLog("Jak to?");
            } else if (intUtils.randomInt(0, 3) == 2) {
                console.emilyLog("Proč?");
            } else if (intUtils.randomInt(0, 3) == 3) {
                console.emilyLog("Co se stalo?");
            } else {
                console.emilyLog("Jak je to možné?");
            }

            // print prompt line
            console.printPrompt();

            // read scanner
            scanner.nextLine();

            // return output
            console.emilyLog("Aha, ok no...");

        } else {

            // check if ask in eng
            if (input.contains(stringUtils.validateInput("how are you"))) {
                console.emilyLog("Ok.");
            } else {
                console.emilyLog("Aha, ok.");
            }
        }
    }

    private void overused(String input) {
        if (input.contains(stringUtils.validateInput("how are you"))) {
            console.emilyLog("We already said that!");
        } else {
            console.emilyLog("To už jsme si řekli!");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}