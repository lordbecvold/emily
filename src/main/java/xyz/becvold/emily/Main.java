package xyz.becvold.emily;

import xyz.becvold.emily.functions.messages.WelcomeMessage;
import xyz.becvold.emily.utils.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class Main {

    // objects initiate
    public static ConsoleUtils console = new ConsoleUtils();
    public static EmilyCore core = new EmilyCore();
    public static WelcomeMessage welcomeMessage = new WelcomeMessage();

    // main app initiate
    public static void main(String[] args) {

        // print spacer
        console.printSpacer();

        // print initiate msg
        console.systemLog("System initiating...");

        // print spacer
        console.printSpacer();

        // print welcome msg function
        welcomeMessage.printWelcomeMessage();

        // init app core
        core.init();
    }
}