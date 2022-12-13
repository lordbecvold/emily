package xyz.becvold.emily;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import xyz.becvold.emily.utils.*;

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
    public FileUtils fileUtils = new FileUtils();
    public ConsoleUtils consoleUtils = new ConsoleUtils();
    public SystemUtils systemUtils = new SystemUtils();
    public StringUtils stringUtils = new StringUtils();

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
                consoleUtils.systemLog("Data folder created!");
            } else {
                consoleUtils.systemLog("Error data folder create failed! - please check app and user permissions");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            }
        } else {

            consoleUtils.systemLog("Data folder successfully found.");
        }
    }

    // function for create database
    public void createDatabase() {

        // check if database exist
        if (fileUtils.checkIfPathExist("data/database.json")) {
            consoleUtils.systemLog("Database successfully found.");
        } else {

            // create database file
            fileUtils.createFile("data/database.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/database.json")) {
                consoleUtils.systemLog("Error database file create failed! - please check app and user permissions");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("Database file successfully created!");
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
            consoleUtils.systemLog("Word-meaning-database successfully found.");
        } else {

            // create phrases database file
            fileUtils.createFile("data/word-meaning-database.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/word-meaning-database.json")) {
                consoleUtils.systemLog("Error Word-meaning-database file create failed! - please check app and user permissions");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("Word-meaning-database file successfully created!");
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
            consoleUtils.systemLog("Memory file successfully found.");
        } else {

            // create memory database file
            fileUtils.createFile("data/memory.json");

            // check if file created
            if (!fileUtils.checkIfPathExist("data/memory.json")) {
                consoleUtils.systemLog("Error memory file create failed! - please check app and user permissions");

                // kill app if data folder not created
                systemUtils.appShutdown(0);
            } else {
                consoleUtils.systemLog("Memory file successfully created!");
            }

            // put default example data to database
            try(PrintWriter output = new PrintWriter(new FileWriter("data/memory.json",true))) {
                output.printf("{\n" +
                        "  \"first-boot-date\": \"" + TimeUtils.getDate()+ "\",\n" +
                        "  \"first-boot-time\": \"" + TimeUtils.getTime("HH:mm:ss") + "\"\n" +
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
}
