/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import operators.MouseOperator;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
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
        int x = 0;
        int y = 0;
        MouseOperator instance = new MouseOperator();
        instance.setMousePosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of moveMouseSmooth method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testMoveMouseSmooth() throws AWTException {
        System.out.println("moveMouseSmooth");
        int x = 0;
        int y = 0;
        MouseOperator instance = new MouseOperator();
        instance.moveMouseSmooth(x, y, 1);
        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        assertEquals(x, pntNow.x);
        assertEquals(y, pntNow.y);
        // TODO review the generated test code and remove the default call to fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of moveMouseHuman method, of class MouseOperator.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void testMoveMouseHuman() throws AWTException {
        System.out.println("moveMouseHuman");
        int x = 50;
        int y = 50;
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
