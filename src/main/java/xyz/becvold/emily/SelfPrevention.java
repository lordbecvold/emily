package xyz.becvold.emily;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.FileHelper;
import xyz.becvold.emily.utils.helpers.ResourcesHelper;
import xyz.becvold.emily.utils.SystemUtils;

/**
 * @author Lukáš Bečvář on 14.12.22
 * @project Emily
 */
public class SelfPrevention {

    // init objects
    public ResourcesHelper resourcesHelper = new ResourcesHelper();
    public FileHelper fileHelper = new FileHelper();
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
        if (!fileHelper.checkIfPathExist("Emily.jar")) {

            // try copy jar file from resources
            resourcesHelper.copyResource(getClass().getClassLoader().getResourceAsStream("EmilyBin.jar"), "Emily.jar");

            // print msg
            consoleUtils.systemLog("(Self-Protection): jar file deleted detected, creating new...");

            // log system msg
            logManager.selfPrevntSystem("jar file deleted detected, creating new...");

            // check if path exist (create check)
            if (fileHelper.checkIfPathExist("Emily.jar")) {

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
