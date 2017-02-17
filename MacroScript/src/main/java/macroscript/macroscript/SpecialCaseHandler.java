/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

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

    public String handleIf(String ifSentence) {

        String toReturn = "";

        try {
            String ifSplittedBySpaces[] = ifSentence.split(" ");
            String splitByEqual[] = ifSplittedBySpaces[1].split("=");

            if (variablesAndValues.containsKey(splitByEqual[0])) {
                if (variablesAndValues.get(splitByEqual[0]) == Integer.parseInt(splitByEqual[1])) {
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
        } catch (NumberFormatException e) {
            //ei oo numero
        } catch (NullPointerException e) {
            //ei ollu parametrii
        }

        return toReturn;
    }

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
