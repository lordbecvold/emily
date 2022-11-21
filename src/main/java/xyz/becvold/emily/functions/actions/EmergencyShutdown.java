package xyz.becvold.emily.functions.actions;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.SystemUtils;

/**
 * @author Lukáš Bečvář on 21.11.22
 * @project Emily
 */
public class EmergencyShutdown {

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public SystemUtils systemUtils = new SystemUtils();

    // check if shutdown initiated
    public boolean isShutdownInit(String input) {
        if (input.equals("kysyoupls")) {
            return true;
        } else {
            return false;
        }
    }

    // shutdown function
    public void emergencyShutdown() {
        console.emilyLog("Byla spuštěna pojistka vypnutí! Vypínám se... :(");
        systemUtils.appShutdown(0);
    }
}
