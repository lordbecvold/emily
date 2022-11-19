package xyz.becvold.emily.utils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class ConsoleUtils {

    // msg color codes
    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_BLACK = "\u001B[30m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_YELLOW = "\u001B[33m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_PURPLE = "\u001B[35m";
    private String ANSI_CYAN = "\u001B[36m";
    private String ANSI_WHITE = "\u001B[37m";

    // msg Background codes
    private String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private String ANSI_RED_BACKGROUND = "\u001B[41m";
    private String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // log string to console with format reset
    public void log(String msg) {
        System.out.println(ANSI_RESET + msg);
    }

    // log system msg
    public void systemLog(String msg) {
        System.out.println(ANSI_YELLOW + "[!] " + ANSI_RESET + msg);
    }

    // print spacer
    public void printSpacer() {
        log(ANSI_WHITE + "====================================================================================");
    }

    // print prompt
    public void printPrompt() {
        System.out.print(ANSI_GREEN + "> " + ANSI_RESET);
    }

    // print emily msg
    public void emilyLog(String msg) {
        System.out.println(ANSI_YELLOW + "[" + ANSI_RED + "Emily" + ANSI_YELLOW + "] " + ANSI_RESET + msg);
    }
}
