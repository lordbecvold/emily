package xyz.becvold.emily;

import xyz.becvold.emily.functions.actions.EmergencyShutdown;
import xyz.becvold.emily.functions.reactions.*;
import xyz.becvold.emily.utils.StringUtils;
import xyz.becvold.emily.utils.ConsoleUtils;

import java.net.UnknownHostException;
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
    public GreetingSystem greeting = new GreetingSystem();
    public EmergencyShutdown emergencyShutdown = new EmergencyShutdown();
    public HowAreYouQuestion howAreYouAsk = new HowAreYouQuestion();
    public WhoAreYouQuestion whoAreYouAsk = new WhoAreYouQuestion();
    public TimeQuestion timeAsk = new TimeQuestion();
    public WhatDayIsQuestion whatDayIsAsk = new WhatDayIsQuestion();
    public WhereAreYouQuestion whereAreYouQuestion = new WhereAreYouQuestion();
    public WhyAreYouQuestion whyAreYouQuestion = new WhyAreYouQuestion();

    // core function
    public void init() throws UnknownHostException {

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

            // check if is an input in the system
            if (isInputFound(input)) {

                // emergency shutdown
                if (emergencyShutdown.isShutdownInit(input)) {
                    emergencyShutdown.emergencyShutdown();
                }

                // greeting
                if (greeting.isExecute(input)) {
                    greeting.onExecute(input);
                }

                // how are you
                if (howAreYouAsk.isExecute(input)) {
                    howAreYouAsk.onExecute(input);
                }

                // who are you
                if (whoAreYouAsk.isExecute(input)) {
                    whoAreYouAsk.onExecute(input);
                }

                // what is time
                if (timeAsk.isExecute(input)) {
                    timeAsk.onExecute(input);
                }

                // where are you
                if (whereAreYouQuestion.isExecute(input)) {
                    whereAreYouQuestion.onExecute(input);
                }

                // why are you
                if (whyAreYouQuestion.isExecute(input)) {
                    whyAreYouQuestion.onExecute(input);
                }

                // what is day
                if (whatDayIsAsk.isExecute(input)) {
                    whatDayIsAsk.onExecute(input);
                }
            } else {
                // not found input msg
                console.emilyLog("Omlouvám se ale nerozuměla jsem vám :(");
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////

        // reinit this function
        init();
    }

    // check if input found with is executed method
    public boolean isInputFound(String input) {
        if (emergencyShutdown.isShutdownInit(input)) {
            return true;
        } else if (greeting.isExecute(input)) {
            return true;
        } else if (howAreYouAsk.isExecute(input)) {
            return true;
        } else if (whoAreYouAsk.isExecute(input)) {
            return true;
        } else if (whereAreYouQuestion.isExecute(input)) {
            return true;
        } else if (whatDayIsAsk.isExecute(input)) {
            return true;
        } else if (whyAreYouQuestion.isExecute(input)) {
            return true;
        } else {
            return false;
        }
    }
}
