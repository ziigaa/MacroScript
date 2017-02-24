/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.gui;

import macroscript.gui.frmMain;
import java.awt.Color;
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
public class frmMainTest {

    public frmMainTest() {
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
     * Test of getColorPickerActive method, of class frmMain.
     */
    @Test
    public void testGetColorPickerActive() {
        System.out.println("getColorPickerActive");
        frmMain instance = new frmMain();
        boolean expResult = false;
        boolean result = instance.getColorPickerActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColorUnderCursor method, of class frmMain.
     */
    @Test
    public void testGetColorUnderCursor() throws Exception {
        System.out.println("getColorUnderCursor");
        frmMain instance = new frmMain();
        Color expResult = new Color(0, 0, 0);
        Color result = instance.getColorUnderCursor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColorHexUnderCursor method, of class frmMain.
     */
    @Test
    public void testGetColorHexUnderCursor() throws Exception {
        System.out.println("getColorHexUnderCursor");
        frmMain instance = new frmMain();
        String expResult = "#000000";
        String result = instance.getColorHexUnderCursor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
