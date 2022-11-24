package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.IntUtils;
import xyz.becvold.emily.utils.TimeUtils;
import xyz.becvold.emily.utils.ConsoleUtils;
import java.util.Random;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class GreetingSystem {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public IntUtils intUtils = new IntUtils();

    // check if meessage is greeting
    public boolean isGreeting(String input) {
        if (input.startsWith("ahoj") && !input.startsWith("ahojjaksemas") && !input.startsWith("ahojjakje")) {
            return true;
        } else if (input.contains("cus")) {
            return true;
        } else if (input.contains("zdravim")) {
            return true;
        } else if (input.contains("nazdar")) {
            return true;
        } else if (input.contains("zdar")) {
            return true;
        } else if (input.contains("cusik")) {
            return true;
        } else if (input.contains("ahojda")) {
            return true;
        } else if (input.contains("cauky")) {
            return true;
        } else if (input.contains("dobryden")) {
            return true;
        } else if (input.contains("dobryvecer")) {
            return true;
        } else if (input.contains("dobreodpoledne")) {
            return true;
        } else if (input.contains("dobrerano")) {
            return true;
        } else if (input.contains("dobrypodvecer")) {
            return true;
        } else if (input.contains("dobrepoledne")) {
            return true;
        } else if (input.contains("dobredopoledne")) {
            return true;
        } else if (input.contains("hello")) {
            return true;
        } else if (input.contains("hi")) {
            return true;
        } else if (input.contains("gutentag")) {
            return true;
        } else if (input.contains("hallo")) {
            return true;
        } else if (input.contains("servus")) {
            return true;
        } else if (input.contains("cc")) {
            return true;
        } else if (input.contains("cs")) {
            return true;
        } else if (input.contains("zdravimvas")) {
            return true;
        }  else {
            return false;
        }
    }

    // Return valid output
    public void getOutput(String input) {

        // check if usages is overused
        if (usages > 30) {

            if (input.startsWith("hello") || input.startsWith("hi")) {
                console.emilyLog("We will not repeat ourselves again!");
            } else if (input.startsWith("hallo") || input.startsWith("gutentag")) {
                console.emilyLog("Wir werden uns nicht noch einmal wiederholen!");
            } else {


                // if usage is 100 (funny message)
                if (usages == 100) {
                    console.emilyLog("Tak ti jsi přijebanej degeš :)");
                } else if (usages == 35) {
                    console.emilyLog("A dál?");
                } else if (usages == 36) {
                    console.emilyLog("A dáál?");
                } else if (usages == 37) {
                    console.emilyLog("A dááál?");
                } else if (usages == 38) {
                    console.emilyLog("A dáááál?");
                } else if (usages == 39) {
                    console.emilyLog("Kámo tak už ale wtf???");
                } else {
                    // generate random number in range
                    int randomInt = intUtils.randomInt(0, 3);

                    // print random overused messages
                    if (randomInt == 0) {
                        console.emilyLog("Sorry, ale nebudu tě už znovu zdravit.");
                    } else if (randomInt == 1) {
                        console.emilyLog("Nebudeme se furt opakovat!");
                    } else if (randomInt == 2) {
                        console.emilyLog("hele neříkej to furt dokola.");
                    } else {
                        console.emilyLog("Tak snad jsme se už pozdravili.");
                    }
                }
            }

        } else {
            if (input.contains("ahoj")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("cus")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("zdravim")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("nazdar")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("zdar")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("cusik")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("ahojda")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("cauky")) {
                console.emilyLog(getRandomGreet());

            } else if (input.contains("dobryden")) {
                if (!TimeUtils.isNightTime() || TimeUtils.isEveningTime()) {
                    console.emilyLog("Dobrý den, přeji.");
                } else {
                    console.emilyLog("Není den, ale dobrý i vám.");
                }

            } else if (input.contains("dobryvecer")) {
                if (TimeUtils.isEveningTime()) {
                    console.emilyLog("Dobrý večer i vám.");
                } else {
                    console.emilyLog("Není večer, ale dobrý i vám.");
                }

            } else if (input.contains("dobreodpoledne")) {
                if (TimeUtils.isAafternoonTime()) {
                    console.emilyLog("Dobré odpoledne i vám.");
                } else {
                    console.emilyLog("Není odpoledne, ale dobré i vám.");
                }

            } else if (input.contains("dobrerano")) {
                if (TimeUtils.isMorningTime()) {
                    console.emilyLog("Dobré ráno i vám.");
                } else {
                    console.emilyLog("Jako není ráno, ale dobré i vám.");
                }

            } else if (input.contains("dobrypodvecer")) {
                if (TimeUtils.isEarlyEveningTime()) {
                    console.emilyLog("Dobrý podvečer i vám.");
                } else {
                    console.emilyLog("No... není sice podvečer, ale dobrý i vám.");
                }

            } else if (input.contains("dobrepoledne")) {
                if (TimeUtils.isNoonTime()) {
                    console.emilyLog("Dobré poledne i vám.");
                } else {
                    console.emilyLog("No.. není sice poledne, ale dobré i vám.");
                }

            } else if (input.contains("dobredopoledne")) {
                if (TimeUtils.isAfterMorningTime()) {
                    console.emilyLog("Dobré dopoledne, přeji.");
                } else {
                    console.emilyLog("Sice není dopoledne, ale dobré i vám.");
                }

            } else if (input.contains("hello")) {
                console.emilyLog("Hello!");

            } else if (input.contains("hi")) {
                console.emilyLog("Hi!");

            } else if (input.contains("gutentag")) {
                console.emilyLog("Hallo!");

            } else if (input.contains("hallo")) {
                console.emilyLog("Hallo!");

            } else if (input.contains("servus")) {
                console.emilyLog("No servus člověče!");

            } else if (input.contains("cc")) {
                console.emilyLog("cs no...");

            } else if (input.contains("cs")) {
                console.emilyLog("cc");

            } else {
                console.emilyLog("Ahoj");
            }
        }

        // set usages + 1
        usages++;
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
