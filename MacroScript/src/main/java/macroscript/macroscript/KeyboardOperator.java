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
    //private boolean errorMade = false;

    //KeyboardOperator.type("yo noob");
    public KeyboardOperator() throws AWTException {
        this.bot = new Robot();
        this.isHuman = false;
    }

    public KeyboardOperator(Robot bot) {
        this.bot = bot;
        this.isHuman = false;
    }

//    public void setHumanTrue() {
//        this.isHuman = true;
//    }
//    
//    public void setHumanFalse() {
//        this.isHuman = false;
//    }
    public void keyDown(char theKey) {
        this.keyFunctionDown = true;
        getChar(theKey);
    }

    public void keyUp(char theKey) {
        keyFunctionUp = true;
        getChar(theKey);
    }

    public void type(CharSequence characters, boolean isHuman) {
        int length = characters.length();
        this.isHuman = isHuman;
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            getChar(character);
        }
    }

    public void getChar(char character) {

        switch (character) {
            case 'a':
                prepareToType(VK_A);
                break;
            case 'b':
                prepareToType(VK_B);
                break;
            case 'c':
                prepareToType(VK_C);
                break;
            case 'd':
                prepareToType(VK_D);
                break;
            case 'e':
                prepareToType(VK_E);
                break;
            case 'f':
                prepareToType(VK_F);
                break;
            case 'g':
                prepareToType(VK_G);
                break;
            case 'h':
                prepareToType(VK_H);
                break;
            case 'i':
                prepareToType(VK_I);
                break;
            case 'j':
                prepareToType(VK_J);
                break;
            case 'k':
                prepareToType(VK_K);
                break;
            case 'l':
                prepareToType(VK_L);
                break;
            case 'm':
                prepareToType(VK_M);
                break;
            case 'n':
                prepareToType(VK_N);
                break;
            case 'o':
                prepareToType(VK_O);
                break;
            case 'p':
                prepareToType(VK_P);
                break;
            case 'q':
                prepareToType(VK_Q);
                break;
            case 'r':
                prepareToType(VK_R);
                break;
            case 's':
                prepareToType(VK_S);
                break;
            case 't':
                prepareToType(VK_T);
                break;
            case 'u':
                prepareToType(VK_U);
                break;
            case 'v':
                prepareToType(VK_V);
                break;
            case 'w':
                prepareToType(VK_W);
                break;
            case 'x':
                prepareToType(VK_X);
                break;
            case 'y':
                prepareToType(VK_Y);
                break;
            case 'z':
                prepareToType(VK_Z);
                break;
//            case '\u00E4'://ä
//                prepareToType(228);
//                break;
//            case '\u00F6'://ö
//                prepareToType(246);
//                break;
            case 'A':
                prepareToType(VK_SHIFT, VK_A);
                break;
            case 'B':
                prepareToType(VK_SHIFT, VK_B);
                break;
            case 'C':
                prepareToType(VK_SHIFT, VK_C);
                break;
            case 'D':
                prepareToType(VK_SHIFT, VK_D);
                break;
            case 'E':
                prepareToType(VK_SHIFT, VK_E);
                break;
            case 'F':
                prepareToType(VK_SHIFT, VK_F);
                break;
            case 'G':
                prepareToType(VK_SHIFT, VK_G);
                break;
            case 'H':
                prepareToType(VK_SHIFT, VK_H);
                break;
            case 'I':
                prepareToType(VK_SHIFT, VK_I);
                break;
            case 'J':
                prepareToType(VK_SHIFT, VK_J);
                break;
            case 'K':
                prepareToType(VK_SHIFT, VK_K);
                break;
            case 'L':
                prepareToType(VK_SHIFT, VK_L);
                break;
            case 'M':
                prepareToType(VK_SHIFT, VK_M);
                break;
            case 'N':
                prepareToType(VK_SHIFT, VK_N);
                break;
            case 'O':
                prepareToType(VK_SHIFT, VK_O);
                break;
            case 'P':
                prepareToType(VK_SHIFT, VK_P);
                break;
            case 'Q':
                prepareToType(VK_SHIFT, VK_Q);
                break;
            case 'R':
                prepareToType(VK_SHIFT, VK_R);
                break;
            case 'S':
                prepareToType(VK_SHIFT, VK_S);
                break;
            case 'T':
                prepareToType(VK_SHIFT, VK_T);
                break;
            case 'U':
                prepareToType(VK_SHIFT, VK_U);
                break;
            case 'V':
                prepareToType(VK_SHIFT, VK_V);
                break;
            case 'W':
                prepareToType(VK_SHIFT, VK_W);
                break;
            case 'X':
                prepareToType(VK_SHIFT, VK_X);
                break;
            case 'Y':
                prepareToType(VK_SHIFT, VK_Y);
                break;
            case 'Z':
                prepareToType(VK_SHIFT, VK_Z);
                break;
//            case '\u00C4':
//                prepareToType(196);
//                break;
//              Ä
//            case '\u00D6':
//                prepareToType(214);
//                break;
//              Ö
            case '`':
                prepareToType(VK_BACK_QUOTE);
                break;
            case '0':
                prepareToType(VK_0);
                break;
            case '1':
                prepareToType(VK_1);
                break;
            case '2':
                prepareToType(VK_2);
                break;
            case '3':
                prepareToType(VK_3);
                break;
            case '4':
                prepareToType(VK_4);
                break;
            case '5':
                prepareToType(VK_5);
                break;
            case '6':
                prepareToType(VK_6);
                break;
            case '7':
                prepareToType(VK_7);
                break;
            case '8':
                prepareToType(VK_8);
                break;
            case '9':
                prepareToType(VK_9);
                break;
            case '-':
                prepareToType(VK_MINUS);
                break;
            case '=':
                prepareToType(VK_EQUALS);
                break;
            case '~':
                prepareToType(VK_SHIFT, VK_BACK_QUOTE);
                break;
            case '!':
                prepareToType(VK_EXCLAMATION_MARK);
                break;
            case '@':
                prepareToType(VK_AT);
                break;
            case '#':
                prepareToType(VK_NUMBER_SIGN);
                break;
            case '$':
                prepareToType(VK_DOLLAR);
                break;
            case '%':
                prepareToType(VK_SHIFT, VK_5);
                break;
            case '^':
                prepareToType(VK_CIRCUMFLEX);
                break;
            case '&':
                prepareToType(VK_AMPERSAND);
                break;
            case '*':
                prepareToType(VK_ASTERISK);
                break;
            case '(':
                prepareToType(VK_LEFT_PARENTHESIS);
                break;
            case ')':
                prepareToType(VK_RIGHT_PARENTHESIS);
                break;
            case '_':
                prepareToType(VK_UNDERSCORE);
                break;
            case '+':
                prepareToType(VK_PLUS);
                break;
            case '\t':
                prepareToType(VK_TAB);
                break;
//            case '\n':
//                prepareToType(VK_ENTER);
//                break;
            case '[':
                prepareToType(VK_OPEN_BRACKET);
                break;
            case ']':
                prepareToType(VK_CLOSE_BRACKET);
                break;
            case '\\':
                prepareToType(VK_BACK_SLASH);
                break;
            case '{':
                prepareToType(VK_SHIFT, VK_OPEN_BRACKET);
                break;
            case '}':
                prepareToType(VK_SHIFT, VK_CLOSE_BRACKET);
                break;
            case '|':
                prepareToType(VK_SHIFT, VK_BACK_SLASH);
                break;
            case ';':
                prepareToType(VK_SEMICOLON);
                break;
            case ':':
                prepareToType(VK_COLON);
                break;
            case '\'':
                prepareToType(VK_QUOTE);
                break;
            case '"':
                prepareToType(VK_QUOTEDBL);
                break;
            case ',':
                prepareToType(VK_COMMA);
                break;
            case '<':
                prepareToType(VK_SHIFT, VK_COMMA);
                break;
            case '.':
                prepareToType(VK_PERIOD);
                break;
            case '>':
                prepareToType(VK_SHIFT, VK_PERIOD);
                break;
            case '/':
                prepareToType(VK_SLASH);
                break;
            case '?':
                prepareToType(VK_SHIFT, VK_SLASH);
                break;
            case ' ':
                prepareToType(VK_SPACE);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    private void prepareToType(int... keyCodes) {
        if (this.isHuman == false && this.keyFunctionDown == false) {
            doType(keyCodes, 0, keyCodes.length);
        } else if (this.keyFunctionDown == false && this.isHuman == true) {
            doHumanType(keyCodes, 0, keyCodes.length);
        } else if (this.isHuman == false && this.keyFunctionDown == true) {
            bot.keyPress(keyCodes[0]);
            this.keyFunctionDown = false;
        } else if (this.isHuman == false && this.keyFunctionUp == true) {
            bot.keyRelease(keyCodes[0]);
            this.keyFunctionDown = false;
        }
    }

    private void doType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }

        bot.keyPress(keyCodes[offset]);
        doType(keyCodes, offset + 1, length - 1);
        bot.keyRelease(keyCodes[offset]);
    }

    private void doHumanType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }

        long sInterval = 100;
        Random rnd = new Random();

        sInterval = (long) rnd.nextInt(300);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

        sInterval = (long) rnd.nextInt(30);
        bot.keyPress(keyCodes[offset]);
        doHumanType(keyCodes, offset + 1, length - 1);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

        bot.keyRelease(keyCodes[offset]);

    }

}
