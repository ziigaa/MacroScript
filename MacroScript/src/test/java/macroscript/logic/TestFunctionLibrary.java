/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas
 */
public class TestFunctionLibrary {

    private Random rnd = new Random();
    private ArrayList<String> ScriptCommands;

    public TestFunctionLibrary() {
        this.ScriptCommands = new ArrayList<>();
        ScriptCommands.clear();
        String[] commands = {"if", "goto", "sleep", "colorPalette", "int", "mouseLeftDown",
            "mouseLeftUp", "mouseRightDown", "mouseRightUp", "setMousePos", "moveMouseSmooth",
            "moveMouseHuman", "mouseLeftClick", "mouseRightClick", "mouseHumanLeftClick",
            "mouseHumanRightClick", "keyDown", "keyUp", "pressEnter", "type", "typeHuman",
            "findColor", "findColorFromPalette", "findColorStartingFromPoint",
            "findColorFromPaletteStartingFromPoint", "@"};
        ScriptCommands.addAll(Arrays.asList(commands));
    }

    public String getRandomCommand() {
        int rndNumber = rnd.nextInt(ScriptCommands.size());
        String command = ScriptCommands.get(rndNumber);
        int paramCount = getParamCountFor(command);

        switch (paramCount) {
            case 0:
                return command;
            case 1:
                if (command.equals("sleep")) {
                    return command + " " + getRndInt(Integer.MAX_VALUE);
                } else {
                    return command + " " + createRandomString(0, true);
                }
            case 2:
                return command + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE);
            case 4:
                return command + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE);
            case 5:
                return command + " " + nextHexColor() + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE);
            case 6:
                return command + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE);
            case 7:
                return command + " " + nextHexColor() + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE);
            case 15:
                return command + " " + nextHexColor() + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + getRndInt(Integer.MAX_VALUE) + " " + getRndInt(Integer.MAX_VALUE)
                        + " " + createRandomString(0, true) + " " + createRandomString(0, true)
                        + createRandomString(0, true) + createRandomString(0, true)
                        + " " + createRandomString(0, true) + " " + createRandomString(0, true);
        }
        return command;
    }

    public ArrayList<String> getScriptCommands() {
        return ScriptCommands;
    }

    public Integer getParamCountFor(String command) {
        if (command.contains("Right") || command.contains("Left") || command.contains("key")
                || command.contains("Enter")) {
            return 0;
        } else if (command.contains("Pos") || command.contains("moveMouse")) {
            return 2;
        } else if (command.contains("goto") || command.contains("sleep")
                || command.contains("int")) {
            return 1;
        } else if (command.contains("type")) {
            return 15;
        } else if (command.equals("findColor")) {
            return 5;
        } else if (command.equals("findColorFromPalette")) {
            return 4;
        } else if (command.equals("findColorStartingFromPoint")) {
            return 7;
        } else if (command.equals("findColorFromPaletteStartingFromPoint")) {
            return 6;
        }
        return 99;
    }

    public String createRandomString(int length, boolean rndLength) {

        if (rndLength == true) {
            length = rnd.nextInt(10) + 1;
        }

        String alphas = "abcdefghijklmnopqrstuvwxyz";

        char[] generatedName = new char[length];

        for (int i = 0; i < length; i++) {
            generatedName[i] = alphas.charAt(rnd.nextInt(alphas.length()));
        }

        return new String(generatedName);
    }

    public Integer getRndInt(int maxValue) {
        return rnd.nextInt(maxValue);
    }

    //getFieldValue(instance.getClass(), "variablesAndValues");
    public String getFieldValue(Object instance, String fieldName) {

        try {
            Class<?> classToInspect = instance.getClass();

            Field fields[] = classToInspect.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);

                try {

                    String fieldToString = field.get(instance).toString();

                    if (field.getName().equals(fieldName)) {
                        return fieldToString;
                    }

                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ScriptMotorTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ScriptMotorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "3rror"; //3rror siksi, ettei se voi olla mikään generoitu arvo..
    }

    public String toHexString(int input) {
        String out = Integer.toHexString(input);
        if (out.length() == 1) {
            out = "0" + out;
        }
        return out;
    }

    public String nextHexColor() {
        return "#" + toHexString(rnd.nextInt(256)) + toHexString(rnd.nextInt(256)) + toHexString(rnd.nextInt(256));
    }

    public char getRndChar() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789,.-  ";
        return chars.charAt(rnd.nextInt(chars.length()));
    }
}
