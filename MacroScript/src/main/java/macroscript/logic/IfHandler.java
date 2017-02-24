/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.logic;

import macroscript.gui.frmLogger;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import macroscript.actions.ColorOperator;

/**
 * For handling if-sentences within the script.
 *
 * @author Joonas
 */
public class IfHandler {

    HashMap<String, Integer> variablesAndValues;
    private final frmLogger myLogger;
    private final FindColorOperator findColorOperation;

    /**
     *      * The constructor.
     *
     * @param variablesAndValues A HashMap containing all the variables and
     * their values.
     * @param findColorOperation The color finding tool.
     * @param myLogger The error logger.
     */
    public IfHandler(HashMap<String, Integer> variablesAndValues, FindColorOperator findColorOperation, frmLogger myLogger) {
        this.variablesAndValues = new HashMap<>();
        this.variablesAndValues = variablesAndValues;
        this.myLogger = myLogger;
        this.findColorOperation = findColorOperation;
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
                myLogger.insert("Variable not found in: " + ifSentence);
                toReturn = "3rror";
                //variable not found
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //ei "="-merkkiä
            String ifSplittedBySpaces[] = ifSentence.split(" ");
            if (ifSplittedBySpaces[1].contains("findColor")) {
                //System.out.println("löyty findColor");
                String colorPoint = findColorOperation.handleFindColorAsParameter(ifSentence);
                if (!colorPoint.contains("-1")) {
                    try {
                        //System.out.println("ifS: " + ifSentence);

                        int beginCommand = 7;

                        if (ifSplittedBySpaces[1].contains("FromPalette")) {
                            beginCommand--;
                        }

                        if (ifSentence.contains("StartingFromPoint")) {
                            beginCommand += 2;
                        }

                        for (int i = beginCommand; i < ifSplittedBySpaces.length; i++) {
                            toReturn = toReturn + ifSplittedBySpaces[i] + " ";
                        }
                        toReturn = toReturn.substring(0, toReturn.length() - 1);
                    } catch (Exception ex) {
                        myLogger.insert("Invalid format in: " + ifSentence + "\nIf-sentence needs to have a condition");
                        //if-lauseella ei ollut ehtoa
                    }
                } else {
                    myLogger.insert("Color not found: " + ifSentence);
                    //väriä ei löytynyt
                    toReturn = "3rror";
                }
            } else {
                myLogger.insert("Invalid format in: " + ifSentence);
            }
        } catch (NullPointerException e) {
            //ei ollu parametrii
            myLogger.insert("Invalid parameter format in: " + ifSentence);
            toReturn = "3rror";
        }
        return toReturn;
    }
}
