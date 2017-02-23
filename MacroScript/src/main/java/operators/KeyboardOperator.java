/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.awt.AWTException;
import java.awt.Robot;
import static java.awt.event.KeyEvent.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The keyboard functions are executed here.
 *
 * @author Joonas
 */
public class KeyboardOperator {

    private Robot bot;
    private boolean isHuman = false;
    private boolean keyFunctionDown = false;
    private boolean keyFunctionUp = false;

    /**
     * The constructor.
     *
     * @throws AWTException If the Robot fails.
     */
    public KeyboardOperator() throws AWTException {
        this.bot = new Robot();
        this.isHuman = false;
    }

    /**
     * Sends a key down message that corresponds a key from the keyboard.
     *
     * @param theKey The key to press
     */
    public void keyDown(char theKey) {
        this.keyFunctionDown = true;
        typeChar(theKey, this.isHuman, this.keyFunctionDown, this.keyFunctionUp);
    }

    /**
     * Sends a key up message that corresponds a key from the keyboard.
     *
     * @param theKey The key to press
     */
    public void keyUp(char theKey) {
        keyFunctionUp = true;
        typeChar(theKey, this.isHuman, this.keyFunctionDown, this.keyFunctionUp);
    }

    /**
     * Sends an enter key press.
     *
     * @param isHuman If true, adds a random Thread.Sleep() before and after the
     * key down event.
     */
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

    /**
     * Sends messages that replicate the function of the keyboard and uses this
     * to type the input.
     *
     * @param characters The input to type
     * @param isHuman If true, adds a random Thread.Sleep() before and after
     * every key down event, including shift if a special character needs it or
     * if the character in question is upper case.
     */
    public void type(CharSequence characters, boolean isHuman) {
        int length = characters.length();
        this.isHuman = isHuman;
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            typeChar(character, isHuman, keyFunctionDown, keyFunctionUp);
        }
    }

    /**
     * Finds the correct keycode for the specified character and either presses,
     * presses and releases or releases the key adding random Thread.sleep()
     * commands on the flow according to given parameters.
     *
     * @param charToType The character to solve the keycode for. Also the
     * character to undergo the specified action as mentioned above.
     * @param isHuman True if random Thread.sleep() times are wanted, false if
     * not.
     * @param onlyDown If the only action wanted is a keyDown function.
     * @param onlyUp If the only action wanted is a keyUp function.
     */
    private void typeChar(char charToType, boolean isHuman, boolean onlyDown, boolean onlyUp) {
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

    /**
     * Adds a Thread.sleep() with a randomized time between 0 and 300 ms.
     */
    private void doRndSleep() {
        Random rnd = new Random();
        long sInterval = (long) rnd.nextInt(300);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
