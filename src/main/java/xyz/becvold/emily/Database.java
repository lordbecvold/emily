package xyz.becvold.emily;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import xyz.becvold.emily.utils.*;
import xyz.becvold.emily.utils.helpers.FileHelper;
import xyz.becvold.emily.utils.helpers.TimeHelper;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Lukáš Bečvář on 09.12.22
 * @project Emily
 */
public class Database {

    // init objects
    public FileHelper fileUtils = new FileHelper();
    public ConsoleUtils consoleUtils = new ConsoleUtils();
    public SystemUtils systemUtils = new SystemUtils();

    // init database functions in start
    public void init() {

        // create data folder
        createDataFolder();

        // create memory data file
        createMemoryFile();

        // create database file
        createDatabase();

        // create phrases database
        createWordDatabase();
    }


    // function for create database folder
    public void createDataFolder() {

        // check if data folder exist
        if (!fileUtils.checkIfPathExist("data/")) {

            // create data path
            fileUtils.createDirectory("data/");

            // check if data path created
            if (fileUtils.checkIfPathExist("data/")) {
                consoleUtils.systemLog("(Database): data folder created!");

                // system log
                Main.logManager.systemLog("data folder created");

            } else {
                consoleUtils.systemLog("(Database): error data folder create failed! - please check app and user permissions");

                // error log
                Main.logManager.errorLog("data folder create failed");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            }
        } else {

            consoleUtils.systemLog("(Database): data folder successfully found.");
        }
    }

    // function for create database
    public void createDatabase() {

        // check if database exist
        if (fileUtils.checkIfPathExist("data/database.json")) {
            consoleUtils.systemLog("(Database): database successfully found.");
        } else {

            // create database file
            fileUtils.createFile("data/database.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/database.json")) {
                consoleUtils.systemLog("(Database): error database file create failed! - please check app and user permissions");

                // error log
                Main.logManager.errorLog("database file create failed");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("(Database): database file successfully created!");

                // system log
                Main.logManager.systemLog("database file successfully created");
            }

            // put default example data to database
            try(PrintWriter output = new PrintWriter(new FileWriter("data/database.json",true))) {
                output.printf("{\n" +
                        "  \"input\": \"output\",\n" +
                        "  \"foo\": \"foo response\",\n" +
                        "  \"cucu\": \"cucu reaction\"\n" +
                        "}");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // function for create word-meaning database
    public void createWordDatabase() {

        // check if phrases database exist
        if (fileUtils.checkIfPathExist("data/word-meaning-database.json")) {
            consoleUtils.systemLog("(Database): word-meaning-database successfully found.");
        } else {

            // create phrases database file
            fileUtils.createFile("data/word-meaning-database.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/word-meaning-database.json")) {
                consoleUtils.systemLog("(Database): error Word-meaning-database file create failed! - please check app and user permissions");

                // error log
                Main.logManager.errorLog("word-meaning-database file create failed!");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("(Database): word-meaning-database file successfully created!");

                // system log
                Main.logManager.systemLog("word-meaning-database file successfully created");
            }

            // put default example data to database
            try(PrintWriter output = new PrintWriter(new FileWriter("data/word-meaning-database.json",true))) {
                output.printf("{\n" +
                        "  \"color\": \"Color is a perception that is created by visible light falling on the retina of the human eye\",\n" +
                        "  \"airplane\": \"An airplane is a flying means of transport.\",\n" +
                        "  \"carpets\": \"Carpets are textiles used to cover floors or walls\"\n" +
                        "}");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // function for create memory system file
    public void createMemoryFile() {

        // check if memory database exist
        if (fileUtils.checkIfPathExist("data/memory.json")) {
            consoleUtils.systemLog("(Database): memory file successfully found.");
        } else {

            // create memory database file
            fileUtils.createFile("data/memory.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/memory.json")) {
                consoleUtils.systemLog("(Database): error memory file create failed! - please check app and user permissions");

                // error log
                Main.logManager.errorLog("memory file create failed");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("(Database): memory file successfully created!");

                // system log
                Main.logManager.systemLog("memory file successfully created");
            }

            // put default example data to database
            try(PrintWriter output = new PrintWriter(new FileWriter("data/memory.json",true))) {
                output.printf("{\n" +
                        "  \"current-date\": \"" + "00.00.00"+ "\",\n" +
                        "  \"first-boot-date\": \"" + TimeHelper.getDate()+ "\",\n" +
                        "  \"first-boot-time\": \"" + TimeHelper.getTime("HH:mm:ss") + "\"\n" +
                        "}");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // function for get database value
    public String getValueFromDatabaseFile(String dbValue, String databaseFile) {
        JSONParser parser = new JSONParser();
        String value = null;
        try {
            Object object = null;
            try {
                object = parser.parse(new FileReader("data/" + databaseFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = (JSONObject) object;
            value = (String) jsonObject.get(dbValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    // fuction for check if value exist in database
    public boolean isValueExistInDatabase(String value, String database) {
        if (getValueFromDatabaseFile(value, database) == null) {
            return false;
        } else {
            return true;
        }
    }

    // fuction for current time update in memory file
    public void memoryCurrentTimeUpdate() {

        // check if memory file exist
        if (!fileUtils.checkIfPathExist("data/memory.json")) {
            createMemoryFile();
        }

        // init new values
        String newCurrentDate = TimeHelper.getDate();
        String newFirstBootDate = getValueFromDatabaseFile("first-boot-date", "memory.json");
        String newFirstBootTime = getValueFromDatabaseFile("first-boot-time", "memory.json");

        // delete old memory file
        fileUtils.deleteFile("data/memory.json");

        // create new memory file with updated values
        try(PrintWriter output = new PrintWriter(new FileWriter("data/memory.json",true))) {
            output.printf("{\n" +
                    "  \"current-date\": \"" + newCurrentDate + "\",\n" +
                    "  \"first-boot-date\": \"" + newFirstBootDate + "\",\n" +
                    "  \"first-boot-time\": \"" + newFirstBootTime + "\"\n" +
                    "}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // save system log
        Main.logManager.systemLog("memory current time updated");
    }
}
