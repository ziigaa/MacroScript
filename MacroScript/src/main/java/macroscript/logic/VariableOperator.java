/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.logic;

import macroscript.gui.frmLogger;
import java.util.HashMap;

/**
 * For handling variables within the script.
 *
 * @author Joonas
 */
public class VariableOperator {

    private HashMap<String, Integer> variablesAndValues;
    private frmLogger myLogger;

    /**
     * The constructor.
     *
     * @param variablesAndValues HashMap on variables and their values.
     * @param myLogger The log that shows what's happening.
     */
    public VariableOperator(HashMap<String, Integer> variablesAndValues, frmLogger myLogger) {
        this.variablesAndValues = variablesAndValues;
        this.myLogger = myLogger;
    }

    /**
     * Handles cases where a variable is given a value, either by assining a
     * simple integer value to it or by a calculation. t. ex. i=3 or i=i*5
     *
     * @param commandLine The line of script-code that does not start with a
     * command
     */
    public void handleVariableSettingAndVariableCalculations(String commandLine) {

        try { //joko muuttujalle ollaan asettamassa arvoa, tai sitten komento on tuntematon

            String splitByEqual[];
            splitByEqual = commandLine.split("=");

            //System.out.println("splByEQ0=" + splitByEqual[0]);
            if (variablesAndValues.containsKey(splitByEqual[0])) {
                try {
                    variablesAndValues.put(splitByEqual[0], Integer.parseInt(splitByEqual[1]));
                } catch (NumberFormatException e) {

                    if (variablesAndValues.containsKey(splitByEqual[1])) {
                        variablesAndValues.put(splitByEqual[0], variablesAndValues.get(splitByEqual[1]));
                        return;
                    }

                    String splitByOperation[];
                    int operationType = 0;

                    if (splitByEqual[1].contains("+")) {
                        splitByOperation = splitByEqual[1].split("\\+");
                        operationType = 1;
                    } else if (splitByEqual[1].contains("-")) {
                        splitByOperation = splitByEqual[1].split("-");
                        operationType = 2;
                    } else if (splitByEqual[1].contains("/")) {
                        splitByOperation = splitByEqual[1].split("/");
                        operationType = 3;
                    } else if (splitByEqual[1].contains("*")) {
                        splitByOperation = splitByEqual[1].split("\\*");
                        operationType = 4;
                    } else {
                        //syntax error
                        myLogger.insert("Syntax error1: " + commandLine);
                        splitByOperation = "010".split("1");
                        return;
                    }

                    int value1 = 0, value2 = 0;

                    try {
                        value1 = Integer.parseInt(splitByOperation[0]);
                    } catch (NumberFormatException ex) {
                        if (variablesAndValues.containsKey(splitByOperation[0])) {
                            value1 = variablesAndValues.get(splitByOperation[0]);
                        } else {
                            myLogger.insert("Syntax error2: " + commandLine);
                            //syntax error
                        }
                    }

                    try {
                        value2 = Integer.parseInt(splitByOperation[1]);
                    } catch (NumberFormatException ex) {
                        if (variablesAndValues.containsKey(splitByOperation[1])) {
                            value2 = variablesAndValues.get(splitByOperation[1]);
                        } else {
                            myLogger.insert("Syntax error3: " + commandLine);
                            //syntax error
                        }
                    }

                    int result = 0;

                    switch (operationType) {
                        case 0:
                            myLogger.insert("Syntax error, unknown operation: " + commandLine);
                            //error
                            break;
                        case 1:
                            result = value1 + value2;
                            break;
                        case 2:
                            result = value1 - value2;
                            break;
                        case 3:
                            result = (int) Math.round((double) value1 / value2);
                            break;
                        case 4:
                            result = value1 * value2;
                            break;
                    }

                    variablesAndValues.put(splitByEqual[0], result);

                } catch (NullPointerException e) {
                    myLogger.insert("Syntax error, parameters seem to be missing: " + commandLine);
                    //ei ollu mitää O.O
                }

            } else {
                myLogger.insert("Unknown command or variable does not exist: " + commandLine);
                //erröööööör, ei oo tehty muuttujaa
            }
        } catch (Exception e) {
            myLogger.insert("Syntax error, unknown command: " + commandLine);
            //errööööör, ei voi splitata, joten tuntematon komento.
        }
    }

    /**
     * Adds a variable in the HashMap that holds all script variables and their
     * values.
     *
     * @param rawData Either a name for the variable in which case it will be
     * assigned the default value of 0, or a variable name and a value for it.
     * t. ex. i=3.
     */
    public void createVariable(String rawData) {

        if (!rawData.contains("=") && !rawData.contains(" ")) {
            myLogger.insert("No value was set for " + rawData + ", so default (=0) will be used.");
            variablesAndValues.put(rawData, 0); //asetetaan oletus 0.
            return;
        }

        try {
            String splitByEqual[] = rawData.split("=");
            if (variablesAndValues.containsKey(splitByEqual[0])) {
                //parametri on jo olemassa
                myLogger.insert("A variable called " + splitByEqual[0] + " already exists. Specifications: " + rawData + " were not set.");
            } else {
                try {
                    variablesAndValues.put(splitByEqual[0], Integer.parseInt(splitByEqual[1]));
                } catch (ArrayIndexOutOfBoundsException e) { //ei arvoa
                    myLogger.insert("No value was set for " + splitByEqual[0] + ". Skipping line.");
                }
            }
        } catch (NumberFormatException e) {
            String splitByEqual[] = rawData.split("=");
            if (variablesAndValues.containsKey(splitByEqual[1])) {
                variablesAndValues.put(splitByEqual[0], variablesAndValues.get(splitByEqual[1]));
            } else {
                myLogger.insert("Syntax error: " + splitByEqual[0] + " needs to get its value as a number or from another variable.");
            }
            //ei oo numero
        } catch (NullPointerException e) {
            myLogger.insert("Syntax error: No value was set for the variable");
            //ei ollu parametrii
        }
    }
}
