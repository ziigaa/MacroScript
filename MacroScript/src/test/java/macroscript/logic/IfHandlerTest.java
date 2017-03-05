/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.logic;

import macroscript.gui.frmLogger;
import java.util.ArrayList;
import java.util.HashMap;
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
public class IfHandlerTest {

    private final TestFunctionLibrary tfl = new TestFunctionLibrary();
    private final frmLogger myLogger = new frmLogger();
    HashMap<String, Integer> variablesAndValues = new HashMap<>();
    ArrayList<String> colorPalette = new ArrayList<>();
    private final FindColorOperator findColorOperation = new FindColorOperator(variablesAndValues, colorPalette, myLogger);

    public IfHandlerTest() {
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
     * Test of handleIf method, of class IfHandler.
     */
    @Test
    public void testHandleIf() {
        for (int i = 0; i < 20; i++) {
            System.out.println("handleIf");

            String variableName = tfl.createRandomString(0, true);

            int variableValue = tfl.getRndInt(Integer.MAX_VALUE);

            variablesAndValues.put(variableName, variableValue);
            IfHandler instance = new IfHandler(variablesAndValues, findColorOperation, myLogger);
            String randomCommand = tfl.getRandomCommand();
            String ifSentence = "if " + variableName + "=" + variableValue + " " + randomCommand;
            String expResult = randomCommand;
            String result = instance.handleIf(ifSentence);
            assertEquals(expResult, result);
            Thread.yield();
        }
    }
}
