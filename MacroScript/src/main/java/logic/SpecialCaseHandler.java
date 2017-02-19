/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;

/**
 *
 * @author Joonas
 */
public class SpecialCaseHandler {

    HashMap<String, Integer> variablesAndValues;

    public SpecialCaseHandler(HashMap<String, Integer> variablesAndValues) {
        this.variablesAndValues = new HashMap<>();
        this.variablesAndValues = variablesAndValues;
    }

    /**
     * Interprets an if-sentence input from the script by splitting it and
     * processing the remaining data.
     *
     * @param ifSentence The sentence to interpret
     * @return If the requirements of the if/sentence are met, then the command
     * after the condition is returned. Otherwise an empty string is returned.
     */
    public String handleIf(String ifSentence) {

        String toReturn = "";

        try {
            String ifSplittedBySpaces[] = ifSentence.split(" ");
            String splitByEqual[] = ifSplittedBySpaces[1].split("=");
            
            int givenValue = 0;
            
            try {
                givenValue = Integer.parseInt(splitByEqual[1]);
            } catch (NumberFormatException e) {
                if (variablesAndValues.containsKey(splitByEqual[1])) {
                    givenValue = variablesAndValues.get(splitByEqual[1]);
                }
            }
            
            if (variablesAndValues.containsKey(splitByEqual[0])) {
                if (variablesAndValues.get(splitByEqual[0]) == givenValue) {
                    for (int i = 2; i < ifSplittedBySpaces.length; i++) {
                        toReturn = toReturn + ifSplittedBySpaces[i] + " ";
                    }
                    toReturn = toReturn.substring(0, toReturn.length() - 1);
                }
            } else {
                //variable not found
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //ei "="-merkkiä
        } catch (NullPointerException e) {
            //ei ollu parametrii
        }

        return toReturn;
    }

    /**
     * Handles cases where a variable is given a value, either by assining a
     * simple integer value to it or by a calculation. t. ex. i=3 or i=i*5
     *
     * @param commandLine The line of script-code that does not start with a
     * command
     */
    public void handleVariableSettingAndVariableCalculations(String commandLine) {
        try {//joko muuttujalle ollaan asettamassa arvoa, tai sitten komento on tuntematon

            String splitByEqual[];
            splitByEqual = commandLine.split("=");

            if (this.variablesAndValues.containsKey(splitByEqual[0])) {
                //laskutoimitusten varalta laita if splittedByEqual[1] ei ole int jne...
                try {
                    variablesAndValues.put(splitByEqual[0], Integer.parseInt(splitByEqual[1]));
                } catch (NumberFormatException e) {

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
                            //syntax error
                        }
                    }

                    try {
                        value2 = Integer.parseInt(splitByOperation[1]);
                    } catch (NumberFormatException ex) {
                        if (variablesAndValues.containsKey(splitByOperation[1])) {
                            value2 = variablesAndValues.get(splitByOperation[1]);
                        } else {
                            //syntax error
                        }
                    }

                    int result = 0;

                    switch (operationType) {
                        case 0:
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
                    //ei ollu mitää O.O
                }

            } else {
                //erröööööör, ei oo tehty muuttujaa
            }
        } catch (Exception e) {
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
        try {
            String splitByEqual[] = rawData.split("=");
            if (variablesAndValues.containsKey(splitByEqual[0])) {
                //parametri on jo olemassa
            } else {
                try {
                    variablesAndValues.put(splitByEqual[0], Integer.parseInt(splitByEqual[1]));
                } catch (ArrayIndexOutOfBoundsException e) {//ei arvoa
                    variablesAndValues.put(splitByEqual[0], 0);//asetetaan oletus 0.
                }
            }
        } catch (NumberFormatException e) {
            //ei oo numero
        } catch (NullPointerException e) {
            //ei ollu parametrii
        }
    }
}
