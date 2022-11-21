package xyz.becvold.emily.functions.reactions;

import xyz.becvold.emily.utils.IntUtils;
import xyz.becvold.emily.utils.TimeUtils;
import xyz.becvold.emily.utils.ConsoleUtils;
import java.util.Random;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class Greeting {

    // usages count
    public int usages = 0;

    // init objects
    public ConsoleUtils console = new ConsoleUtils();
    public IntUtils intUtils = new IntUtils();

    // check if meessage is greeting
    public boolean isGreeting(String input) {
        if (input.startsWith("ahoj") && !input.startsWith("ahoj jak se mas") && !input.startsWith("ahoj jak je")) {
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
        } else if (input.startsWith("servus")) {
            return true;
        } else if (input.startsWith("cc")) {
            return true;
        } else if (input.startsWith("cs")) {
            return true;
        }  else {
            return false;
        }
    }

    // Return valid output
    public void getOutput(String input) {

        // check if usages is overloaded
        if (usages > 5) {

            if (input.startsWith("hello") || input.startsWith("hi")) {
                console.emilyLog("We will not repeat ourselves again!");
            } else if (input.startsWith("hallo") || input.startsWith("guten tag")) {
                console.emilyLog("Wir werden uns nicht noch einmal wiederholen!");
            } else {


                // if usage is 100 (funny message)
                if (usages == 100) {
                    console.emilyLog("Tak ti jsi přijebanej degeš :)");
                } else if (usages == 10) {
                    console.emilyLog("A dál?");
                } else if (usages == 11) {
                    console.emilyLog("A dáál?");
                } else if (usages == 12) {
                    console.emilyLog("A dááál?");
                } else if (usages == 13) {
                    console.emilyLog("A dáááál?");
                } else if (usages == 14) {
                    console.emilyLog("Kámo tak už ale wtf???");
                } else {
                    // generate random number in range
                    int randomInt = intUtils.randomInt(0, 3);

                    // print random overloaded messages
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
                    console.emilyLog("Dobrý den, přeji.");
                } else {
                    console.emilyLog("Není den, ale dobrý i vám.");
                }

            } else if (input.startsWith("dobry vecer")) {
                if (TimeUtils.isEveningTime()) {
                    console.emilyLog("Dobrý večer i vám.");
                } else {
                    console.emilyLog("Není večer, ale dobrý i vám.");
                }

            } else if (input.startsWith("dobre odpoledne")) {
                if (TimeUtils.isAafternoonTime()) {
                    console.emilyLog("Dobré odpoledne i vám.");
                } else {
                    console.emilyLog("Není odpoledne, ale dobré i vám.");
                }

            } else if (input.startsWith("dobre rano")) {
                if (TimeUtils.isMorningTime()) {
                    console.emilyLog("Dobré ráno i vám.");
                } else {
                    console.emilyLog("Jako není ráno, ale dobré i vám.");
                }

            } else if (input.startsWith("dobry podvecer")) {
                if (TimeUtils.isEarlyEveningTime()) {
                    console.emilyLog("Dobrý podvečer i vám.");
                } else {
                    console.emilyLog("No... není sice podvečer, ale dobrý i vám.");
                }

            } else if (input.startsWith("dobre poledne")) {
                if (TimeUtils.isNoonTime()) {
                    console.emilyLog("Dobré poledne i vám.");
                } else {
                    console.emilyLog("No.. není sice poledne, ale dobré i vám.");
                }

            } else if (input.startsWith("dobre dopoledne")) {
                if (TimeUtils.isAfterMorningTime()) {
                    console.emilyLog("Dobré dopoledne, přeji.");
                } else {
                    console.emilyLog("Sice není dopoledne, ale dobré i vám.");
                }

            } else if (input.startsWith("hello")) {
                console.emilyLog("Hello!");

            } else if (input.startsWith("hi")) {
                console.emilyLog("Hi!");

            } else if (input.startsWith("guten tag")) {
                console.emilyLog("Hallo!");

            } else if (input.startsWith("hallo")) {
                console.emilyLog("Hallo!");

            } else if (input.startsWith("servus")) {
                console.emilyLog("No servus člověče!");

            } else if (input.startsWith("cc")) {
                console.emilyLog("cs no...");

            } else if (input.startsWith("cs")) {
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
