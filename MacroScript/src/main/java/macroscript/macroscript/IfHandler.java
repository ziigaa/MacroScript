/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joonas <>
 */
public class IfHandler {

    HashMap<String, Integer> variablesAndValues;

    public IfHandler(HashMap<String, Integer> variablesAndValues) {
        this.variablesAndValues = new HashMap<>();
        this.variablesAndValues = variablesAndValues;
    }

    public String handleIf(String ifSentence) {

        String ifSplittedBySpaces[] = ifSentence.split(" ");
        String splitByEqual[] = ifSplittedBySpaces[1].split("=");
        String toReturn = "";

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
        return toReturn;
    }
}
