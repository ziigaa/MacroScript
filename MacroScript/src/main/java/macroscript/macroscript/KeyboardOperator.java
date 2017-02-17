/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

/**
 *
 * @author Joonas
 */
import java.awt.AWTException;
import java.awt.Robot;
import static java.awt.event.KeyEvent.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyboardOperator {

    private Robot bot;
    private boolean isHuman = false;
    private boolean keyFunctionDown = false;
    private boolean keyFunctionUp = false;

    public KeyboardOperator() throws AWTException {
        this.bot = new Robot();
        this.isHuman = false;
    }

    public void keyDown(char theKey) {
        this.keyFunctionDown = true;
        typeChar(theKey, this.isHuman, this.keyFunctionDown, this.keyFunctionUp);
    }

    public void keyUp(char theKey) {
        keyFunctionUp = true;
        typeChar(theKey, this.isHuman, this.keyFunctionDown, this.keyFunctionUp);
    }

    public void pressEnter(boolean isHuman) {
        if (isHuman == true) {
            doRndSleep();
        }
        bot.keyPress(VK_ENTER);
        if (isHuman == true) {
            doRndSleep();
        }
        bot.keyRelease(VK_ENTER);
    }

    public void type(CharSequence characters, boolean isHuman) {
        int length = characters.length();
        this.isHuman = isHuman;
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            typeChar(character, isHuman, keyFunctionDown, keyFunctionUp);
        }
    }

    public void typeChar(char charToType, boolean isHuman, boolean onlyDown, boolean onlyUp) {
        String alphas = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharSet1 = "!\"#¤%&/()=";
        String specialCharSet2 = ",.-";
        int charInt = 0;
        boolean shiftNeeded = false;

        if (alphas.contains(Character.toString(charToType))) {
            charInt = alphas.indexOf(charToType) + VK_A;
        } else if (alphas.toUpperCase().contains(Character.toString(charToType))) {
            charInt = alphas.toUpperCase().indexOf(charToType) + VK_A;
            shiftNeeded = true;
        } else if (numbers.contains(Character.toString(charToType))) {
            charInt = numbers.indexOf(charToType) + VK_0;
        } else if (charToType == ' ') {
            charInt = VK_SPACE;
        } else if (specialCharSet1.contains(Character.toString(charToType))) {
            shiftNeeded = true;

            charInt = VK_0 + 1 + specialCharSet1.indexOf(charToType);

            if (charToType == '=') {
                charInt = VK_0;
            }
        } else if (specialCharSet2.contains(Character.toString(charToType))) {
            if (charToType == '.') {
                charInt = VK_PERIOD;
            } else if (charToType == ',') {
                charInt = VK_COMMA;
            } else if (charToType == '-') {
                charInt = VK_MINUS;
            }
        }
        if (isHuman == true) {
            doRndSleep();
        }
        if (shiftNeeded == true) {
            bot.keyPress(VK_SHIFT);
            if (isHuman == true) {
                doRndSleep();
            }
        }
        if (onlyDown == true) {
            onlyDown = false;
            bot.keyPress(charInt);
            return;
        }
        if (onlyUp == true) {
            onlyUp = false;
            bot.keyRelease(charInt);
            return;
        }

        bot.keyPress(charInt);
        if (isHuman == true) {
            doRndSleep();
        }

        bot.keyRelease(charInt);

        if (shiftNeeded == true) {
            if (isHuman == true) {
                doRndSleep();
            }
            bot.keyRelease(VK_SHIFT);
            shiftNeeded = false;
        }
    }

    public void doRndSleep() {
        Random rnd = new Random();
        long sInterval = (long) rnd.nextInt(300);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
