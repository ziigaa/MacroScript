/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.logic;

import java.util.ArrayList;
import java.util.HashMap;
import macroscript.gui.frmLogger;
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
public class FindColorOperatorTest {

    private final TestFunctionLibrary tfl = new TestFunctionLibrary();
    private final frmLogger myLogger = new frmLogger();
    HashMap<String, Integer> variablesAndValues = new HashMap<>();
    ArrayList<String> colorPalette = new ArrayList<>();

    public FindColorOperatorTest() {
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
     * Test of handleFindColorAsParameter method, of class FindColorOperator.
     */
    @Test
    public void testHandleFindColorAsParameter() {

        System.out.println("handleFindColorAsParameter");
        String commandLine = "setMousePos findColor #000000 0 0 40 40";

        FindColorOperator instance = new FindColorOperator(variablesAndValues, colorPalette, myLogger);

        String result = instance.handleFindColorAsParameter(commandLine);

        String splitResult[] = result.split(" ");

        int xValue = Integer.parseInt(splitResult[0]);
        int yValue = Integer.parseInt(splitResult[1]);

        if (xValue < 0 || yValue < 0 || xValue > 40 || yValue > 40) {
            fail("Faulty coordinates");
        }

        String expResult = xValue + " " + yValue;

        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidHex method, of class FindColorOperator.
     */
    @Test
    public void testIsValidHex() {
        System.out.println("isValidHex");
        String hex = tfl.nextHexColor();
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        
        FindColorOperator instance = new FindColorOperator(variablesAndValues, colorPalette, myLogger);
        boolean expResult = true;
        boolean result = instance.isValidHex(hex);
        assertEquals(expResult, result);
    }

}
