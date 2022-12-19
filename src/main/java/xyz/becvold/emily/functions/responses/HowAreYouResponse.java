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
    private final StringHelper stringHelper = new StringHelper();
    private final IntegerHelper integerHelper = new IntegerHelper();
    private final Scanner scanner = new Scanner(System.in);

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
        if (input.contains(stringHelper.validateInput("jak se máš"))) {
            console.emilyLog("Mám se dobře a co ty?");
        } else if (input.contains(stringHelper.validateInput("jak je"))) {
            console.emilyLog("Celkem to de a co ty?");
        } else if (input.contains(stringHelper.validateInput("jak to jde"))) {
            console.emilyLog("Jde to dobře a co ty?");
        } else if (input.contains(stringHelper.validateInput("jak to de"))) {
            console.emilyLog("V klidu a co ty?");
        } else if (input.contains(stringHelper.validateInput("how are you"))) {
            console.emilyLog("I am nice, and you?");
        } else {
            console.emilyLog("Mám se dobře, děkuji za optání a co ty?");
        }

        // print prompt line
        console.printPrompt();

        // get input form user
        String inputAsk = scanner.nextLine();

        // validate input
        inputAsk = stringHelper.validateInput(inputAsk);

        // remove spaces
        inputAsk = inputAsk.replaceAll(" ", "");

        // check if valid return
        if (inputAsk.contains(stringHelper.validateInput("dobře")) || inputAsk.contains(stringHelper.validateInput("dobrý"))) {
            console.emilyLog("Tak to je dobře!");
        } else if (inputAsk.contains(stringHelper.validateInput("jde to")) || inputAsk.contains(stringHelper.validateInput("de to")) || inputAsk.contains(stringHelper.validateInput("celkem ok")) || inputAsk.contains(stringHelper.validateInput("v poho")) || inputAsk.contains("pohoda") || inputAsk.contains(stringHelper.validateInput("v klidu")) || inputAsk.contains("ok")) {
            console.emilyLog("Tak hlavně že to jde no...");
        } else if (inputAsk.contains(stringHelper.validateInput("špatně")) || inputAsk.contains(stringHelper.validateInput("nic moc")) || inputAsk.contains(stringHelper.validateInput("na píču")) || inputAsk.contains(stringHelper.validateInput("na hovno")) || inputAsk.contains(stringHelper.validateInput("debilně")) || inputAsk.contains(stringHelper.validateInput("na kokot"))) {

            // generate random ask
            if (integerHelper.randomInt(0, 3) == 0) {
                console.emilyLog("Jak je to možné?");
            } else if (integerHelper.randomInt(0, 3) == 1) {
                console.emilyLog("Jak to?");
            } else if (integerHelper.randomInt(0, 3) == 2) {
                console.emilyLog("Proč?");
            } else if (integerHelper.randomInt(0, 3) == 3) {
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
            if (input.contains(stringHelper.validateInput("how are you"))) {
                console.emilyLog("Ok.");
            } else {
                console.emilyLog("Aha, ok.");
            }
        }
    }

    private void overused(String input) {
        if (input.contains(stringHelper.validateInput("how are you"))) {
            console.emilyLog("We already said that!");
        } else {
            console.emilyLog("To už jsme si řekli!");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
}