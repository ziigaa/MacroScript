/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.actions;

import java.awt.AWTException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import macroscript.gui.TextBoxTest;
import macroscript.logic.TestFunctionLibrary;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joonas
 */
public class KeyboardOperatorTest {

    private TextBoxTest testFrame;
    private final TestFunctionLibrary tfl = new TestFunctionLibrary();
    
    
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
        try {
            System.out.println("keyDown");
            char theKey = tfl.getRndChar();
            KeyboardOperator instance = new KeyboardOperator();
            
            testFrame = new TextBoxTest();
            testFrame.requestFocusForTextArea();
            
            Thread.sleep(1000);
            
            instance.keyDown(theKey);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //char snatchedChar = testFrame.getTestText().charAt(0);
            testFrame.dispose();
            assertEquals(theKey, testFrame.returnKeyEventAsChar());
            
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of keyUp method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testKeyUp() throws AWTException {
        System.out.println("keyUp");
        char theKey = tfl.getRndChar();
        KeyboardOperator instance = new KeyboardOperator();

        testFrame = new TextBoxTest();
        testFrame.requestFocusForTextArea();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        instance.keyUp(theKey);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        char snatchedChar = testFrame.returnKeyEventAsChar();
        testFrame.dispose();
        assertEquals(theKey, snatchedChar);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of type method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testType() throws AWTException {
        System.out.println("type");
        CharSequence characters = tfl.createRandomString(0, true)
                + " " + tfl.createRandomString(0, true)
                + " " + tfl.createRandomString(0, true);

        boolean isHuman = false;
        KeyboardOperator instance = new KeyboardOperator();

        testFrame = new TextBoxTest();
        testFrame.requestFocusForTextArea();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        instance.type(characters, isHuman);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(characters.toString(), testFrame.getTestText());
        testFrame.dispose();
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

        testFrame = new TextBoxTest();
        testFrame.requestFocusForTextArea();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        instance.pressEnter(isHuman);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals("\n", testFrame.getTestText());
        testFrame.dispose();
    }

    /**
     * Test of typeChar method, of class KeyboardOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testTypeChar() throws AWTException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("typeChar");
        char charToType = tfl.getRndChar();
        boolean isHuman = false;

        KeyboardOperator instance = new KeyboardOperator();

        testFrame = new TextBoxTest();
        testFrame.requestFocusForTextArea();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Class<?>[] paramTypes = {char.class, boolean.class, boolean.class, boolean.class};

        Method typeChar = instance.getClass().getDeclaredMethod("typeChar", paramTypes);
        typeChar.setAccessible(true);
        typeChar.invoke(instance, charToType, false, false, false);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyboardOperatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        char snatchedChar = testFrame.returnKeyEventAsChar();
        assertEquals(charToType, snatchedChar);
        testFrame.dispose();
    }
}
