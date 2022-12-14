package xyz.becvold.emily;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.FileUtils;
import xyz.becvold.emily.utils.ResourcesUtils;
import xyz.becvold.emily.utils.SystemUtils;

/**
 * @author Lukáš Bečvář on 14.12.22
 * @project Emily
 */
public class SelfPrevention {

    // init objects
    public ResourcesUtils resourcesUtils = new ResourcesUtils();
    public FileUtils fileUtils = new FileUtils();
    public ConsoleUtils consoleUtils = new ConsoleUtils();
    public LogManager logManager = new LogManager();
    public SystemUtils systemUtils = new SystemUtils();

    // main init function
    public void init() {

        // check if app running in IntelliJ (for dev disable prevent)
        if (systemUtils.isIntelliJRunning()) {
            return;
        }

        // check if emily jar exist
        if (!fileUtils.checkIfPathExist("Emily.jar")) {

            // try copy jar file from resources
            resourcesUtils.copyResource(getClass().getClassLoader().getResourceAsStream("EmilyBin.jar"), "Emily.jar");

            // print msg
            consoleUtils.systemLog("(Self-Protection): jar file deleted detected, creating new...");

            // log system msg
            logManager.selfPrevntSystem("jar file deleted detected, creating new...");

            // check if path exist (create check)
            if (fileUtils.checkIfPathExist("Emily.jar")) {

                // print msg
                consoleUtils.systemLog("(Self-Protection): jar file created");

                // log system msg
                logManager.selfPrevntSystem("jar file created");

            } else {

                // print error msg
                consoleUtils.systemLog("(Self-Protection): jar file not created, reinit running!");

                // log error
                logManager.selfPrevntSystem("jar file created failed");

                // run init
                init();
            }
        }
    }
}
