/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
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
public class ColorOperatorTest {

    public ColorOperatorTest() {
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
     * Test of findColorStartingFromPoint method, of class ColorOperator.
     */
    @Test
    public void testFindColorStartingFromPoint() {
        System.out.println("findColorStartingFromPoint");
        Color color = Color.BLACK;
        Point startingPoint = new Point(30, 30);
        Rectangle field = new Rectangle(0, 0, 60, 60);
        ColorOperator instance = new ColorOperator();
        Point unexpResult = new Point(-1, -1);
        Point result = instance.findColorStartingFromPoint(color, startingPoint, field);
        System.out.println(result);
        assertNotSame(unexpResult, result);
    }

    /**
     * Test of findColorFromPaletteStartingFromPoint method, of class
     * ColorOperator.
     */
    @Test
    public void testFindColorFromPaletteStartingFromPoint() {
        System.out.println("findColorFromPaletteStartingFromPoint");
        ArrayList<String> colorPalette = new ArrayList<>();
        colorPalette.add("#000000");
        colorPalette.add("#ffffff");
        Point startingPoint = new Point(30, 30);
        Rectangle field = new Rectangle(0, 0, 60, 60);
        ColorOperator instance = new ColorOperator();
        Point unexpResult = new Point(-1, -1);
        Point result = instance.findColorFromPaletteStartingFromPoint(colorPalette, startingPoint, field);
        assertNotSame(unexpResult, result);
    }

    /**
     * Test of findColor method, of class ColorOperator.
     */
    @Test
    public void testFindColor() {
        System.out.println("findColor");
        Color color = Color.BLACK;
        Rectangle field = new Rectangle(0, 0, 30, 30);
        ColorOperator instance = new ColorOperator();
        Point unexpResult = new Point(-1, -1);
        Point result = instance.findColor(color, field);
        assertNotSame(unexpResult, result);
    }

    /**
     * Test of findColorFromPalette method, of class ColorOperator.
     */
    @Test
    public void testFindColorFromPalette() {
        System.out.println("findColorFromPalette");
        ArrayList<String> colorPalette = new ArrayList<>();
        colorPalette.add("#000000");
        colorPalette.add("#ffffff");
        Rectangle field = new Rectangle(0, 0, 30, 30);
        ColorOperator instance = new ColorOperator();
        Point unexpResult = new Point(-1, -1);
        Point result = instance.findColorFromPalette(colorPalette, field);
        assertNotSame(unexpResult, result);
    }

    /**
     * Test of hexToRGB method, of class ColorOperator.
     */
    @Test
    public void testHexToRGB() {
        System.out.println("hexToRGB");
        String colorAsHex = "#ffffff";
        ColorOperator instance = new ColorOperator();
        Color expResult = Color.WHITE;
        Color result = instance.hexToRGB(colorAsHex);
        assertEquals(expResult, result);
    }

}
