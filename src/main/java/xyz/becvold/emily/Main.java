package xyz.becvold.emily;

import xyz.becvold.emily.utils.console.ConsoleUtils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class Main {

    // objects initiate
    public static ConsoleUtils console = new ConsoleUtils();
    public static EmilyCore core = new EmilyCore();

    // main app initiate
    public static void main(String[] args) throws InterruptedException {

        // print spacer
        console.printSpacer();

        // print initiate msg
        console.systemLog("System initiating...");

        // print spacer
        console.printSpacer();

        // init app core
        core.init();
    }
}