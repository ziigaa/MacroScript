/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.actions;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import macroscript.logic.TestFunctionLibrary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas
 */
public class MouseOperatorTest {

    private final TestFunctionLibrary tfl = new TestFunctionLibrary();

    public MouseOperatorTest() {
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
     * Test of leftDown method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testLeftDown() throws AWTException {
        System.out.println("leftDown");
        MouseOperator instance = new MouseOperator();
        instance.leftDown();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of leftUp method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testLeftUp() throws AWTException {
        System.out.println("leftUp");
        MouseOperator instance = new MouseOperator();
        instance.leftUp();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of leftClick method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testLeftClick() throws AWTException {
        System.out.println("leftClick");
        MouseOperator instance = new MouseOperator();
        instance.leftClick();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rightDown method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testRightDown() throws AWTException {
        System.out.println("rightDown");
        MouseOperator instance = new MouseOperator();
        instance.rightDown();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rightUp method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testRightUp() throws AWTException {
        System.out.println("rightUp");
        MouseOperator instance = new MouseOperator();
        instance.rightUp();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of leftHumanClick method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testLeftHumanClick() throws AWTException {
        System.out.println("leftHumanClick");
        MouseOperator instance = new MouseOperator();
        instance.leftHumanClick();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rightClick method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testRightClick() throws AWTException {
        System.out.println("rightClick");
        MouseOperator instance = new MouseOperator();
        instance.rightClick();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rightHumanClick method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testRightHumanClick() throws AWTException {
        System.out.println("rightHumanClick");
        MouseOperator instance = new MouseOperator();
        instance.rightHumanClick();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMousePosition method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testSetMousePosition() throws AWTException {
        System.out.println("setMousePosition");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int x = tfl.getRndInt(screenWidth);
        int y = tfl.getRndInt(screenHeight);
        
        MouseOperator instance = new MouseOperator();
        instance.setMousePosition(x, y);

        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();

        assertEquals(x, pntNow.x);
        assertEquals(y, pntNow.y);
    }

    /**
     * Test of moveMouseSmooth method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testMoveMouseSmooth() throws AWTException {
        System.out.println("moveMouseSmooth");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int x = tfl.getRndInt(screenWidth);
        int y = tfl.getRndInt(screenHeight);
        
        MouseOperator instance = new MouseOperator();
        instance.moveMouseSmooth(x, y, 1);
        
        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        
        assertEquals(x, pntNow.x);
        assertEquals(y, pntNow.y);
    }

    /**
     * Test of moveMouseHuman method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testMoveMouseHuman() throws AWTException {
        System.out.println("moveMouseHuman");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int x = tfl.getRndInt(screenWidth);
        int y = tfl.getRndInt(screenHeight);
        
        int steps = 20;
        int arch = 20;
        
        MouseOperator instance = new MouseOperator();
        instance.moveMouseHuman(x, y, steps, arch);
        
        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        
        if (Math.abs(pntNow.x - x) <= 3 && Math.abs(pntNow.y - y) <= 3) {
            assertTrue(true);
        } else {
            fail("NOT close enough");
        }
    }
}
