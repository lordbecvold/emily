package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.IntUtils;
import xyz.becvold.emily.utils.StringUtils;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class HowAreYouQuestion {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public Scanner scanner = new Scanner(System.in);
    public IntUtils intUtils = new IntUtils();
    public StringUtils stringUtils = new StringUtils();

    // check if meessage is how are you?
    public boolean isExecute(String input) {
        if (input.contains("jaksemas")) {
            return true;
        } else if (input.contains("jakje")) {
            return true;
        } else if (input.contains("jaktojde")) {
            return true;
        } else if (input.contains("jaktode")) {
            return true;
        } else if (input.contains("howareyou")) {
            return true;
        } else if (input.contains("ahojjaksemas")) {
            return true;
        } else if (input.contains("ahojjakje")) {
            return true;
        } else if (input.contains("jaksemate")) {
            return true;
        } else {
            return false;
        }
    }

    // execute output
    public void onExecute(String input) {

        // check if ask is overused
        if (usages > 30) {

            // print overused message
            if (input.contains("howareyou")) {
                console.emilyLog("We already said that!");
            } else {
                if (usages == 35) { // 10 usages (funny message)
                    console.emilyLog("Nebudu se opakovat wtf???");
                } else if (usages == 100) { // 100 usages (funny message)
                    console.emilyLog("Tak tobě mrdá, kámo :)");
                } else {
                    console.emilyLog("To už jsme si řekli!");
                }
            }

        } else {

            // generate valid output
            if (input.contains("jaksemas")) {
                console.emilyLog("Mám se dobře a co ty?");
            } else if (input.contains("jak e")) {
                console.emilyLog("Celkem to de a co ty?");
            } else if (input.contains("jaktojde")) {
                console.emilyLog("Jde to dobře a co ty?");
            } else if (input.contains("jaktode")) {
                console.emilyLog("V klidu a co ty?");
            } else if (input.contains("howareyou")) {
                console.emilyLog("I am nice, and you?");
            } else if (input.contains("ahojjaksemas")) {
                console.emilyLog("Čau, jo dobře a co ty?");
            } else if (input.contains("ahojjakje")) {
                console.emilyLog("Ahoj, no jako celkem ok");
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
            if (inputAsk.contains("dobre") || inputAsk.contains("dobry")) {
                console.emilyLog("Tak to je dobře!");
            } else if (inputAsk.contains("deto") || inputAsk.contains("celkemok") || inputAsk.contains("vpoho") || inputAsk.contains("pohoda") || inputAsk.contains("vklidu") || inputAsk.contains("ok")) {
                console.emilyLog("Tak hlavně že to jde no...");
            } else if (inputAsk.contains("spatne") || inputAsk.contains("nicmoc") || inputAsk.contains("napicu") || inputAsk.contains("nahovno") || inputAsk.contains("debilne") || inputAsk.contains("nakokot")) {

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
                if (input.contains("howareyou")) {
                    console.emilyLog("Ok.");
                } else {
                    console.emilyLog("Aha, ok.");
                }
            }
        }

        // set usages + 1
        usages++;
    }
}
