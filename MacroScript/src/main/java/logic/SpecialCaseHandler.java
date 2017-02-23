/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import gui.frmLogger;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import operators.ColorOperator;

/**
 * For handling if-sentences, color finding operations and variables within the
 * script.
 *
 * @author Joonas
 */
public class SpecialCaseHandler {

    HashMap<String, Integer> variablesAndValues;
    ArrayList<String> colorPalette;
    private final ColorOperator colorOperation;
    private frmLogger myLogger;

    /**
     * The constructor.
     *
     * @param variablesAndValues A HashMap containing all the variables and
     * their values.
     * @param colorPalette The ArrayList for colorPalette variable within the
     * script.
     * @param myLogger The error logger.
     */
    public SpecialCaseHandler(HashMap<String, Integer> variablesAndValues, ArrayList<String> colorPalette, frmLogger myLogger) {
        this.variablesAndValues = new HashMap<>();
        this.variablesAndValues = variablesAndValues;
        this.colorOperation = new ColorOperator();
        this.colorPalette = new ArrayList<>();
        this.colorPalette = colorPalette;
        this.myLogger = myLogger;
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
                String colorPoint = handleFindColorAsParameter(ifSentence);
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

    /**
     * When any color finding operation is used from the class ColorOperator it
     * needs to be processed here.
     *
     * @param commandLine The command line containing the color finding
     * operation
     * @return The coordinates as String. Format "x y" t. ex. "50 100"
     */
    public String handleFindColorAsParameter(String commandLine) {
        String splitBySpaces[] = commandLine.split(" ");
        int method = 0;
        boolean rightColorFormat = false;

        if (splitBySpaces[1].equals("findColor")) {
            method = 1;
        } else if (splitBySpaces[1].equals("findColorStartingFromPoint")) {
            method = 2;
        } else if (splitBySpaces[1].equals("findColorFromPalette")) {
            method = 3;
        } else if (splitBySpaces[1].equals("findColorFromPaletteStartingFromPoint")) {
            method = 4;
        } else {
            myLogger.insert("Syntax error5: " + commandLine);
            //tuntematon findColor
            return "3rror";
        }

        int parameterPlaceFix = 1;

        if (method == 1 || method == 2) {
            if (splitBySpaces[2].length() == 7 && splitBySpaces[2].charAt(0) == '#' && isValidHex(splitBySpaces[2]) == true) {
                parameterPlaceFix = 1;
                rightColorFormat = true;
            }
        } else if (method == 3 || method == 4) {
            if (!colorPalette.isEmpty()) {
                parameterPlaceFix = 0;
                rightColorFormat = true;
            }
        }

        if (rightColorFormat == false) {
            if (method == 1 || method == 2) {
                myLogger.insert("The color input is in a faulty format: " + commandLine);
            } else if (method == 3 || method == 4) {
                myLogger.insert("ColorPalette is empty: " + commandLine);
            }
            return "3rror"; //joko väri ei ollut hex-muodossa tai jos käytössä on colorPalette, niin se oli tyhjä
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        Point startPoint = new Point(-1, -1);
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, startX = 0, startY = 0;

        try {

            x1 = Integer.parseInt(splitBySpaces[2 + parameterPlaceFix]);
            y1 = Integer.parseInt(splitBySpaces[3 + parameterPlaceFix]);
            x2 = Integer.parseInt(splitBySpaces[4 + parameterPlaceFix]);
            y2 = Integer.parseInt(splitBySpaces[5 + parameterPlaceFix]);

            if (method == 2 || method == 4) {
                startX = Integer.parseInt(splitBySpaces[6 + parameterPlaceFix]);
                startY = Integer.parseInt(splitBySpaces[7 + parameterPlaceFix]);
                if (isBetween(startX, x1, x2) == false || isBetween(startY, y1, y2) == false) {
                    myLogger.insert("The start point needs to be in the area: " + commandLine);
                    return "3rror"; //aloituspiste ei alueella
                }
                startPoint.x = startX;
                startPoint.y = startY;
            }

        } catch (Exception e) {
            myLogger.insert("Syntax error6: " + commandLine);
            return "3rror"; //epäkelpoja numeroita tai parametrejä puuttuu
        }

        if (isBetween(x1, 0, screenWidth) == false
                || isBetween(y1, 0, screenHeight) == false
                || isBetween(x2, x1, screenWidth) == false
                || isBetween(y2, y1, screenHeight) == false) {
            myLogger.insert("The points need to be placed within the correct pixel range: " + commandLine + "\nThe correct range for x is from 0 to " + screenWidth + " and for y from 0 to " + screenHeight);
            return "3rror"; //pisteet eivät ole näytön alueella
        }

        if (x1 == x2 || y1 == y2) {

            myLogger.insert("Rectangle width and height must be > 0: " + commandLine);
            return "3rror";
        }

        Rectangle area = new Rectangle();
        area.setRect(x1, y1, x2 - x1, y2 - y1);
        Point colorCoodrinates = new Point(-1, -1);

        switch (method) {
            case 1:
                colorCoodrinates = colorOperation.findColor(colorOperation.hexToRGB(splitBySpaces[2]), area);
                break;
            case 2:
                colorCoodrinates = colorOperation.findColorStartingFromPoint(colorOperation.hexToRGB(splitBySpaces[2]), startPoint, area);
                break;
            case 3:
                colorCoodrinates = colorOperation.findColorFromPalette(colorPalette, area);
                break;
            case 4:
                colorCoodrinates = colorOperation.findColorFromPaletteStartingFromPoint(colorPalette, startPoint, area);
                break;
        }

        return colorCoodrinates.x + " " + colorCoodrinates.y;
    }

    /**
     * This is used to check if a given integer value is inbetween the given
     * parameters.
     *
     * @param value The value which is compared to the parameters
     * @param low Parameter for the lowest possible number (inclusive)
     * @param high Parameter for the highest possible number (inclusive)
     * @return true if the value is between the given parameters. False if the
     * number is not between the given parameters.
     */
    private boolean isBetween(int value, int low, int high) {
        if (value <= high && value >= low) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the given parameter is a valid number in hex format. For
     * example #FFFFFF and #000000 are valid.
     *
     * @param hex The String to check
     * @return True if String is a hex number, false if not.
     */
    public boolean isValidHex(String hex) {
        for (int i = 1; i < hex.length(); i++) {
            if (Character.digit(hex.charAt(i), 16) == -1) {
                return false;
            }
        }
        return true;
    }
}
