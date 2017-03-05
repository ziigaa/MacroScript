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
 * For handling color finding operations within the script.
 *
 * @author Joonas
 */
public class FindColorOperator {

    HashMap<String, Integer> variablesAndValues;
    ArrayList<String> colorPalette;
    private final ColorOperator colorOperation;
    private final frmLogger myLogger;

    /**
     * The constructor.
     *
     * @param variablesAndValues A HashMap containing all the variables and
     * their values.
     * @param colorPalette The ArrayList for colorPalette variable within the
     * script.
     * @param myLogger The error logger.
     */
    public FindColorOperator(HashMap<String, Integer> variablesAndValues, ArrayList<String> colorPalette, frmLogger myLogger) {
        this.variablesAndValues = new HashMap<>();
        this.variablesAndValues = variablesAndValues;
        this.colorOperation = new ColorOperator();
        this.colorPalette = new ArrayList<>();
        this.colorPalette = colorPalette;
        this.myLogger = myLogger;
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
            myLogger.insert("Syntax error (FindColorOperator.java@handleColorAsParameter: " + commandLine);
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
            myLogger.insert("Syntax error: FindColorOperator@handleFindColorAsParameter unusable values or parameters missing: " + commandLine);
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
