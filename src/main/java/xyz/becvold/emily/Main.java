package xyz.becvold.emily;

import xyz.becvold.emily.functions.messages.RandomQuestions;
import xyz.becvold.emily.functions.messages.WelcomeMessage;
import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.TimeUtils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class Main {

    // objects initiate
    public static ConsoleUtils console = new ConsoleUtils();
    public static EmilyCore core = new EmilyCore();
    public static WelcomeMessage welcomeMessage = new WelcomeMessage();
    public static RandomQuestions randomQuestions = new RandomQuestions();
    public static Database database = new Database();
    public static LogManager logManager = new LogManager();
    public static SelfPrevention selfPrevention = new SelfPrevention();

    // variable for check if function found
    public static int inputFound;

    // variable for check usages reset
    public static String currentDate;
    
    // main app initiate
    public static void main(String[] args) throws Exception {

        // print spacer ///////////////////////////////////////////////////////
        console.printSpacer();

        // print initiate msg
        console.systemLog("System initiating...");

        // init database system
        database.init();

        // init log manager
        logManager.init();

        // init self prevention
        selfPrevention.init();

        // print spacer ///////////////////////////////////////////////////////
        console.printSpacer();

        // print welcome msg function
        welcomeMessage.printWelcomeMessage();

        // print random question
        randomQuestions.getRandomQuestion();

        // set starting date
        currentDate = TimeUtils.getDate();

        // init log
        logManager.systemLog("System initiated!");

        // init app core
        core.init();
    }
}