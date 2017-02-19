/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import operators.KeyboardOperator;
import java.awt.AWTException;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joonas
 */
public class KeyboardOperatorTest {

    public KeyboardOperatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of keyDown method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testKeyDown() throws AWTException {
        System.out.println("keyDown");
        char theKey = ' ';
        KeyboardOperator instance = new KeyboardOperator();
        instance.keyDown(theKey);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of keyUp method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testKeyUp() throws AWTException {
        System.out.println("keyUp");
        char theKey = ' ';
        KeyboardOperator instance = new KeyboardOperator();
        instance.keyUp(theKey);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of type method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testType() throws AWTException {
        System.out.println("type");
        CharSequence characters = "a";
        boolean isHuman = false;
        KeyboardOperator instance = new KeyboardOperator();
        instance.type(characters, isHuman);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pressEnter method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testPressEnter() throws AWTException {
        System.out.println("pressEnter");
        boolean isHuman = false;
        KeyboardOperator instance = new KeyboardOperator();
        instance.pressEnter(isHuman);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of typeChar method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testTypeChar() throws AWTException {
        System.out.println("typeChar");
        char charToType = ' ';
        boolean isHuman = false;

        KeyboardOperator instance = new KeyboardOperator();
        Component a = new Component() {
        };

        KeyListener keyChecker = new KeyListener() {
            public char typedChar;

            @Override
            public void keyPressed(KeyEvent ke) {
                typedChar = ke.getKeyChar();
                System.out.println("yessss press: " + typedChar);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                typedChar = ke.getKeyChar();
                System.out.println("yessss release: " + typedChar);
                if (typedChar == ke.getKeyChar()) {

                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                typedChar = ke.getKeyChar();
                System.out.println("yessss typed: " + typedChar);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public char getTypedChar() {
                return typedChar;
            }
        };
        a.addKeyListener(keyChecker);
        a.requestFocus();
        instance.type((CharSequence) String.valueOf(charToType), isHuman);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
