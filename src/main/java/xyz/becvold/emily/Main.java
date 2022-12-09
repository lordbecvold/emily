package xyz.becvold.emily;

import xyz.becvold.emily.functions.messages.WelcomeMessage;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.TimeUtils;
import java.net.UnknownHostException;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class Main {

    // objects initiate
    public static ConsoleUtils console = new ConsoleUtils();
    public static EmilyCore core = new EmilyCore();
    public static WelcomeMessage welcomeMessage = new WelcomeMessage();
    public static Database database = new Database();

    // variable for check if function found
    public static int inputFound;

    // variable for check usages reset
    public static String currentDate;
    
    // main app initiate
    public static void main(String[] args) throws UnknownHostException {

        // print spacer ///////////////////////////////////////////////////////
        console.printSpacer();

        // print initiate msg
        console.systemLog("System initiating...");

        // init database system
        database.init();

        // print spacer ///////////////////////////////////////////////////////
        console.printSpacer();

        // print welcome msg function
        welcomeMessage.printWelcomeMessage();
        
        // set starting date
        currentDate = TimeUtils.getDate();

        // init app core
        core.init();
    }
}