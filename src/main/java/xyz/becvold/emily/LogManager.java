package xyz.becvold.emily;

import xyz.becvold.emily.utils.ConsoleUtils;
import xyz.becvold.emily.utils.helpers.FileHelper;
import xyz.becvold.emily.utils.SystemUtils;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Lukáš Bečvář on 13.12.22
 * @project Emily
 */
public class LogManager {

    // init objects
    public FileHelper fileHelper = new FileHelper();
    public ConsoleUtils consoleUtils = new ConsoleUtils();
    public SystemUtils systemUtils = new SystemUtils();

    // init log system in app start
    public void init() {

        // create log dir (if not exist)
        createLogDir();
    }

    public void createLogDir() {
        // check if data folder exist
        if (!fileHelper.checkIfPathExist("data/logs/")) {

            // create data path
            fileHelper.createDirectory("data/logs/");

            // check if data path created
            if (fileHelper.checkIfPathExist("data/logs/")) {
                consoleUtils.systemLog("(Log-manager): logs folder created!");
            } else {
                consoleUtils.systemLog("(Log-manager): error data folder create failed! - please check app and user permissions");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            }
        } else {

            consoleUtils.systemLog("(Log-manager): logs folder successfully found.");
        }
    }

    // Save log to file
    public void saveLog(String log, String logFile) {

        // create log dir
        if (!Files.exists(Path.of("data/logs/"))) {
            createLogDir();
        }

        // create log file
        if (!fileHelper.checkIfPathExist("data/logs/" + logFile)) {
            fileHelper.createFile("data/logs/" + logFile);
        }

        // get time
        String time = TimeHelper.getTime("HH:mm:ss") + " - " + TimeHelper.getDate();

        // try save log to file
        try {
            if (Files.notExists(Paths.get("data/logs/" + logFile))) {
                File f = new File(String.valueOf(Paths.get("data/logs/" + logFile)));
                f.createNewFile();
            }
            try (PrintWriter output = new PrintWriter(new FileWriter("data/logs/" + logFile, true))) {
                output.printf("%s\r\n", "[" + time + "]: " + log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // save system log
    public void systemLog(String log) {
        saveLog(log, "system.log");
    }

    // save error log
    public void errorLog(String log) {
        saveLog(log, "error.log");
    }

    // save self prevent
    public void selfPrevntSystem(String log) {
        saveLog(log, "self-prevent.log");
    }

    // Delete all logs
    public void deleteAllLogs() {
        fileHelper.purgeDirectory("data/logs/");
    }

    // Delete concrete log file
    public void deleteLogByName(String logName) {
        fileHelper.deleteFile("data/logs/" + logName);
    }
}
