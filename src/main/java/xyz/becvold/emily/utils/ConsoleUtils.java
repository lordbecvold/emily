package xyz.becvold.emily.utils;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class ConsoleUtils {

    // msg color codes
    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_YELLOW = "\u001B[33m";
    private String ANSI_WHITE = "\u001B[37m";

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

    // print line break
    public void printLineBreak() {
        System.out.println("\n");
    }

    // print prompt
    public void printPrompt() {
        System.out.print(ANSI_GREEN + "> " + ANSI_RESET);
    }

    // print prompt
    public void printPromptRed() {
        System.out.print(ANSI_RED + "> " + ANSI_RESET);
    }

    // print emily msg
    public void emilyLog(String msg) {
        System.out.println(ANSI_YELLOW + "[" + ANSI_RED + "Emily" + ANSI_YELLOW + "] " + ANSI_RESET + msg);
    }
}
