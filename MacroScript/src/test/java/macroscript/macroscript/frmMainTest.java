/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas <>
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
        Color expResult = null;
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
        String expResult = "";
        String result = instance.getColorHexUnderCursor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColors method, of class frmMain.
     */
    @Test
    public void testSetColors() throws Exception {
        System.out.println("setColors");
        frmMain instance = new frmMain();
        instance.setColors();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadFile method, of class frmMain.
     */
    @Test
    public void testLoadFile() {
        System.out.println("loadFile");
        frmMain instance = new frmMain();
        instance.loadFile();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveAs method, of class frmMain.
     */
    @Test
    public void testSaveAs() {
        System.out.println("saveAs");
        frmMain instance = new frmMain();
        instance.saveAs();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class frmMain.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        frmMain.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
