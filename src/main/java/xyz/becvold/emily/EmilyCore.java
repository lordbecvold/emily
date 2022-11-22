package xyz.becvold.emily;

import xyz.becvold.emily.functions.actions.EmergencyShutdown;
import xyz.becvold.emily.functions.reactions.*;
import xyz.becvold.emily.utils.StringUtils;
import xyz.becvold.emily.utils.ConsoleUtils;
import java.util.Scanner;

/**
 * @author Lukáš Bečvář on 17.11.22
 * @project Emily
 */
public class EmilyCore {

    // instances initiate
    public ConsoleUtils console = new ConsoleUtils();
    public Scanner scanner = new Scanner(System.in);
    public StringUtils stringUtils = new StringUtils();

    // instances of functions
    public Greeting greeting = new Greeting();
    public EmergencyShutdown emergencyShutdown = new EmergencyShutdown();
    public HowAreYouAsk howAreYouAsk = new HowAreYouAsk();
    public WhoAreYouAsk whoAreYouAsk = new WhoAreYouAsk();
    public TimeAsk timeAsk = new TimeAsk();
    public WhatDayIsAsk whatDayIsAsk = new WhatDayIsAsk();

    // core function
    public void init() {

        // print prompt line
        console.printPrompt();

        // get user input
        String input = scanner.nextLine();

        // process reaction ///////////////////////////////////////////////////////////////////////

        // check if input not empty
        if (input.isEmpty()) {
            console.emilyLog("Cože? Tvá zpráva je prázdná!");
        } else {

            // validate input
            input = stringUtils.validateInput(input);

            // emergency shutdown
            if (emergencyShutdown.isShutdownInit(input)) {
                emergencyShutdown.emergencyShutdown();
            }

            // greeting
            else if (greeting.isGreeting(input)) {
                greeting.getOutput(input);
            }

            // how are you ask
            else if (howAreYouAsk.isHowAreYou(input)) {
                howAreYouAsk.answerAndAsk(input);
            }

            // who are you ask
            else if (whoAreYouAsk.isWhoAreYouAsked(input)) {
                whoAreYouAsk.sayWhoAreYou(input);
            }

            // what is time
            else if (timeAsk.isTimeCheck(input)) {
                timeAsk.timeAskAnswer(input);
            }

            // what is day
            else if (whatDayIsAsk.isWhatDayAsk(input)) {
                whatDayIsAsk.whatDayAnswer(input);

        } else {
                // not found input msg
                console.emilyLog("Omlouvám se ale nerozuměla jsem vám :(");
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////

        // reinit this function
        init();
    }
}
