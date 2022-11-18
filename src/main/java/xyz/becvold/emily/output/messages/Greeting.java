package xyz.becvold.emily.output.messages;

import xyz.becvold.emily.utils.TimeUtils;
import xyz.becvold.emily.utils.console.ConsoleUtils;
import java.util.Random;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class Greeting {

    // init objects
    public static ConsoleUtils console = new ConsoleUtils();

    // check if meessage is greeting
    public static boolean isGreeting(String input) {
        if (input.startsWith("ahoj")) {
            return true;
        } else if (input.startsWith("cus")) {
            return true;
        } else if (input.startsWith("zdravim")) {
            return true;
        } else if (input.startsWith("nazdar")) {
            return true;
        } else if (input.startsWith("zdar")) {
            return true;
        } else if (input.startsWith("cusik")) {
            return true;
        } else if (input.startsWith("ahojda")) {
            return true;
        } else if (input.startsWith("cauky")) {
            return true;
        } else if (input.startsWith("dobry den")) {
            return true;
        } else if (input.startsWith("dobry vecer")) {
            return true;
        } else if (input.startsWith("dobre odpoledne")) {
            return true;
        } else if (input.startsWith("dobre rano")) {
            return true;
        } else if (input.startsWith("dobry podvecer")) {
            return true;
        } else if (input.startsWith("dobre poledne")) {
            return true;
        } else if (input.startsWith("hello")) {
            return true;
        } else if (input.startsWith("hi")) {
            return true;
        } else if (input.startsWith("guten tag")) {
            return true;
        } else if (input.startsWith("hallo")) {
            return true;
        }  else {
            return false;
        }
    }

    // Return valid output
    public static void getOutput(String input) {
        if (input.startsWith("ahoj")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("cus")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("zdravim")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("nazdar")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("zdar")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("cusik")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("ahojda")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("cauky")) {
            console.emilyLog(getRandomGreet());

        } else if (input.startsWith("dobry den")) {
            if (!TimeUtils.isNightTime() || TimeUtils.isEveningTime()) {
                console.emilyLog("Dobrý den přeji.");
            } else {
                console.emilyLog("Není den ale dobrý i vám.");
            }

        } else if (input.startsWith("dobry vecer")) {
            if (TimeUtils.isEveningTime()) {
                console.emilyLog("Dobrý večer i vám.");
            } else {
                console.emilyLog("Není večer ale dobrý i vám.");
            }

        } else if (input.startsWith("dobre odpoledne")) {
            if (TimeUtils.isAafternoonTime()) {
                console.emilyLog("Dobré odpoledne i vám.");
            } else {
                console.emilyLog("Není odpoledne ale dobré i vám.");
            }

        } else if (input.startsWith("dobre rano")) {
            if (TimeUtils.isMorningTime()) {
                console.emilyLog("Dobré ráno i vám.");
            } else {
                console.emilyLog("Jako není ráno ale dobré i vám.");
            }

        } else if (input.startsWith("dobry podvecer")) {
            if (TimeUtils.isEarlyEveningTime()) {
                console.emilyLog("Dobrý podvečer i vám.");
            } else {
                console.emilyLog("No, není sice podvečer ale dobrý i vám.");
            }

        } else if (input.startsWith("dobre poledne")) {
            if (TimeUtils.isNoonTime()) {
                console.emilyLog("Dobré poledne i vám.");
            } else {
                console.emilyLog("No, není sice poledne ale dobré i vám.");
            }

        } else if (input.startsWith("dobre dopoledne")) {
            if (TimeUtils.isAfterMorningTime()) {
                console.emilyLog("Dobré dopoledne přeji.");
            } else {
                console.emilyLog("Sice není dopoledne ale dobré i vám.");
            }

        } else if (input.startsWith("hello")) {
            console.emilyLog("Hello!");

        } else if (input.startsWith("hi")) {
            console.emilyLog("Hi!");

        } else if (input.startsWith("guten tag")) {
            console.emilyLog("Hallo!");

        } else if (input.startsWith("hallo")) {
            console.emilyLog("Hallo!");

        }  else {
            console.emilyLog("Ahoj");
        }
    }

    // get random great from array
    public static String getRandomGreet() {
        String[] rooms = {"Ahoj.", "Čus!", "Zdravím tě.", "Ahojda!", "Čauky.", "Nazdar!"};
        String currentRoom;
        Random rand = new Random();
        currentRoom = rooms[rand.nextInt( rooms.length)];
        return currentRoom;
    }
}
