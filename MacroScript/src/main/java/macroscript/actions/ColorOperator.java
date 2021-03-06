/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.actions;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * For finding colors on the screen.
 *
 * @author Joonas
 */
public class ColorOperator {

    private ArrayList<Color> colorPaletteAsColor;

    /**
     * The constructor.
     */
    public ColorOperator() {
        this.colorPaletteAsColor = new ArrayList<>();
    }

    /**
     * The method searches for a color in a spiraling manner starting from a
     * specified point within a specified rectangle.
     *
     * @param color The color to search for
     * @param startingPoint The point where to start from
     * @param field The rectangle which limits the search area
     * @return The first point where the color was found. If the color cannot be
     * found in the specified area return will be Point(-1, -1)
     */
    public Point findColorStartingFromPoint(Color color, Point startingPoint, Rectangle field) {
        try {
            Robot bot = new Robot();
            BufferedImage fieldCapture = bot.createScreenCapture(field);
            int x = (int) startingPoint.getX() - (int) field.getX();
            int y = (int) startingPoint.getY() - (int) field.getY();
            int direction = 0, length = 1;
            int rgbcolor = color.getRGB();
            if (rgbcolor == fieldCapture.getRGB(x, y)) {
                return new Point((int) field.getX() + x, (int) field.getY() + y);
            }
            while ((x > 2) && (y > 2) && (x < field.getWidth() - 2) && (y < field.getHeight() - 2)) {
                for (int i = 1; i <= length; i++) {
                    switch (direction) {
                        case 0:
                            y = y - 1;
                            break;
                        case 1:
                            x = x + 1;
                            break;
                        case 2:
                            y = y + 1;
                            break;
                        case 3:
                            x = x - 1;
                            break;
                    }
                    if (rgbcolor == fieldCapture.getRGB(x, y)) {
                        return new Point((int) field.getX() + x, (int) field.getY() + y);
                    }
                }
                direction = (direction + 1) % 4;
                if ((direction % 2) == 0) {
                    length = length + 1;
                }
            }
            return new Point(-1, -1);
        } catch (java.awt.AWTException ex) {
            return new Point(-1, -1);
        }
    }

    /**
     * The method searches for multiple colors in a spiraling manner starting
     * from a specified point within a specified rectangle.
     *
     * @param colorPalette A list of colors in hex code. t. ex. #000000 or
     * #ffffff
     * @param startingPoint The point where to start from
     * @param field The rectangle which limits the search area
     * @return The first point that has a matching color in the colorPalette. If
     * the color cannot be found in the specified area return will be Point(-1,
     * -1)
     */
    public Point findColorFromPaletteStartingFromPoint(ArrayList<String> colorPalette, Point startingPoint, Rectangle field) {
        try {

            Robot bot = new Robot();
            BufferedImage fieldCapture = bot.createScreenCapture(field);
            int x = (int) startingPoint.getX() - (int) field.getX();
            int y = (int) startingPoint.getY() - (int) field.getY();
            int direction = 0, length = 1;
            colorPaletteAsColor = getColorPaletteAsRGB(colorPalette);
            for (Color i : colorPaletteAsColor) {
                if (i.getRGB() == fieldCapture.getRGB(x, y)) {
                    return new Point((int) field.getX() + x, (int) field.getY() + y);
                }
            }
            while ((x > 2) && (y > 2) && (x < field.getWidth() - 2) && (y < field.getHeight() - 2)) {
                for (int i = 1; i <= length; i++) {
                    switch (direction) {
                        case 0:
                            y = y - 1;
                            break;
                        case 1:
                            x = x + 1;
                            break;
                        case 2:
                            y = y + 1;
                            break;
                        case 3:
                            x = x - 1;
                            break;
                    }
                    for (Color j : colorPaletteAsColor) {
                        if (j.getRGB() == fieldCapture.getRGB(x, y)) {
                            return new Point((int) field.getX() + x, (int) field.getY() + y);
                        }
                    }
                }
                direction = (direction + 1) % 4;
                if ((direction % 2) == 0) {
                    length = length + 1;
                }
            }
            return new Point(-1, -1);
        } catch (java.awt.AWTException ex) {
            return new Point(-1, -1);
        }
    }

    /**
     * Searches for a color within a rectangle. Iterates from left to right one
     * pixel line at a time.
     *
     * @param color The color to search for
     * @param field The area where to search from
     * @return The first point where the color was found. If the color cannot be
     * found in the specified area return will be Point(-1, -1)
     */
    public Point findColor(Color color, Rectangle field) {
        try {
            Robot bot = new Robot();
            BufferedImage fieldCapture = bot.createScreenCapture(field);
            int colorRGB = color.getRGB();
            for (int y = 0; y < (int) field.getHeight(); y++) {
                for (int x = 0; x < (int) field.getWidth(); x++) {
                    if (fieldCapture.getRGB(x, y) == colorRGB) {
                        return new Point(x + (int) field.getX(), y + (int) field.getY());
                    }
                }
            }
        } catch (java.awt.AWTException ex) {
            return new Point(-1, -1);
        }
        return new Point(-1, -1);
    }

    /**
     * Searches for multiple colors within a rectangle. Iterates from left to
     * right one pixel line at a time.
     *
     * @param colorPalette A list of colors in hex code. t. ex. #000000 or
     * #ffffff
     * @param field The area where to search from
     * @return The first point that has a matching color in the colorPalette. If
     * the color cannot be found in the specified area return will be Point(-1,
     * -1)
     */
    public Point findColorFromPalette(ArrayList<String> colorPalette, Rectangle field) {
        try {
            Robot bot = new Robot();
            BufferedImage fieldCapture = bot.createScreenCapture(field);
            colorPaletteAsColor = getColorPaletteAsRGB(colorPalette);
            for (int y = 0; y < (int) field.getHeight(); y++) {
                for (int x = 0; x < (int) field.getWidth(); x++) {
                    for (Color i : colorPaletteAsColor) {
                        if (fieldCapture.getRGB(x, y) == i.getRGB()) {
                            return new Point(x + (int) field.getX(), y + (int) field.getY());
                        }
                    }
                }
            }
        } catch (java.awt.AWTException ex) {
            return new Point(-1, -1);
        }
        return new Point(-1, -1);
    }

    /**
     * Converts a list of colors in hex format into a list of colors as Color
     * variables.
     *
     * @param colorsAsHex The list containing the hex colors
     * @return An ArrayList containing the converted Color variables
     */
    private ArrayList<Color> getColorPaletteAsRGB(ArrayList<String> colorsAsHex) {
        ArrayList<Color> colors = new ArrayList<>();
        for (String i : colorsAsHex) {
            colors.add(hexToRGB(i));
        }
        return colors;
    }

    /**
     * Converts hex color string into a Color object.
     *
     * @param colorAsHex The color as hex code. t. ex. #000000 or #ffffff
     * @return The same color as a Color object
     */
    public Color hexToRGB(String colorAsHex) {
        return new Color(
                Integer.valueOf(colorAsHex.substring(1, 3), 16),
                Integer.valueOf(colorAsHex.substring(3, 5), 16),
                Integer.valueOf(colorAsHex.substring(5, 7), 16));
    }
}
