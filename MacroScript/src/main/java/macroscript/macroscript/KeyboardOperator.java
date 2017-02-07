/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

/**
 *
 * @author Joonas <>
 */
import com.sun.glass.events.KeyEvent;
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

    public KeyboardOperator(Robot bot) {
        this.bot = bot;
        this.isHuman = false;
    }

    public void keyDown(char theKey) {
        this.keyFunctionDown = true;
        typeChar(theKey, isHuman, keyFunctionDown, keyFunctionUp, false);
    }

    public void keyUp(char theKey) {
        keyFunctionUp = true;
        typeChar(theKey, isHuman, keyFunctionDown, keyFunctionUp, false);
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
            if (Character.isUpperCase(character) == true) {
                character = Character.toLowerCase(character);
                typeChar(character, isHuman, keyFunctionDown, keyFunctionUp, true);
            } else {
                typeChar(character, isHuman, keyFunctionDown, keyFunctionUp, false);
            }
        }
    }

    //eti javan vapaa muttuja
    //esim. toiminnasta olis kutakuinkin:
    //$muuttuja = charToType
    //charInt = VK_$muuttuja.toUpperCase
    public void typeChar(char charToType, boolean isHuman, boolean onlyDown, boolean onlyUp, boolean shiftNeeded) {
        int charInt = 0;
        switch (charToType) {
            case 'a':
                charInt = VK_A;
                break;
            case 'b':
                charInt = VK_B;
                break;
            case 'c':
                charInt = VK_C;
                break;
            case 'd':
                charInt = VK_D;
                break;
            case 'e':
                charInt = VK_E;
                break;
            case 'f':
                charInt = VK_F;
                break;
            case 'g':
                charInt = VK_G;
                break;
            case 'h':
                charInt = VK_H;
                break;
            case 'i':
                charInt = VK_I;
                break;
            case 'j':
                charInt = VK_J;
                break;
            case 'k':
                charInt = VK_K;
                break;
            case 'l':
                charInt = VK_L;
                break;
            case 'm':
                charInt = VK_M;
                break;
            case 'n':
                charInt = VK_N;
                break;
            case 'o':
                charInt = VK_O;
                break;
            case 'p':
                charInt = VK_P;
                break;
            case 'q':
                charInt = VK_Q;
                break;
            case 'r':
                charInt = VK_R;
                break;
            case 's':
                charInt = VK_S;
                break;
            case 't':
                charInt = VK_T;
                break;
            case 'u':
                charInt = VK_U;
                break;
            case 'v':
                charInt = VK_V;
                break;
            case 'w':
                charInt = VK_W;
                break;
            case 'x':
                charInt = VK_X;
                break;
            case 'y':
                charInt = VK_Y;
                break;
            case 'z':
                charInt = VK_Z;
                break;
            case ' ':
                charInt = VK_SPACE;
                break;
        }
        if (onlyDown == true) {
            onlyDown = false;
            bot.keyPress(charInt);
        }
        if (onlyUp == true) {
            onlyUp = false;
            bot.keyRelease(charInt);
        }
        if (shiftNeeded == true) {
            if (isHuman == true) {
                doRndSleep();
            }
            bot.keyPress(VK_SHIFT);
        }
        if (isHuman == true) {
            doRndSleep();
            bot.keyPress(charInt);
            doRndSleep();
            bot.keyRelease(charInt);
        } else if (isHuman == false) {
            bot.keyPress(charInt);
            bot.keyRelease(charInt);
        }
        if (shiftNeeded == true) {
            if (isHuman == true) {
                doRndSleep();
            }
            bot.keyRelease(VK_SHIFT);
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
