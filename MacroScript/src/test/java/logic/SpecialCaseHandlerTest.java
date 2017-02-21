/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import gui.frmLogger;
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
public class SpecialCaseHandlerTest {
    
    private TestFunctionLibrary tfl = new TestFunctionLibrary();
    private frmLogger myLogger = new frmLogger();
    
    public SpecialCaseHandlerTest() {
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
     * Test of handleIf method, of class SpecialCaseHandler.
     */
    @Test
    public void testHandleIf() {
        System.out.println("handleIf");
        
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        
        variablesAndValues.put("i", 3);
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);
        String ifSentence = "if i=3 setMousePos 1 1";
        String expResult = "setMousePos 1 1";
        String result = instance.handleIf(ifSentence);
        assertEquals(expResult, result);
    }

    /**
     * Test of createVariable method, of class SpecialCaseHandler.
     * AND
     * Test of handleVariableSettingAndVariableCalculations method, of class SpecialCaseHandler.
     */
    @Test
    public void testHandleVariableSettingAndVariableCalculations() {
        
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);
        
        System.out.println("testCreateVariableAndHandleVariableSettingAndVariableCalculations");
        String variableName = tfl.createRandomString(0, true);
        String commandLine1 = variableName + "=2";
        String commandLine2 = variableName + "=" + variableName + "*3";
        String commandLine3 = variableName + "=" + variableName + "*" + variableName;
        String commandLine4 = variableName + "=" + variableName + "-6";
        String commandLine5 = variableName + "=" + variableName + "/5";
        String commandLine6 = variableName + "=" + variableName + "+4";
        
        instance.createVariable(commandLine1);
        assertEquals("{" + variableName + "=2}", tfl.getFieldValue(instance, "variablesAndValues"));
        
        instance.handleVariableSettingAndVariableCalculations(commandLine2);
        assertEquals("{" + variableName + "=6}", tfl.getFieldValue(instance, "variablesAndValues"));
        
        instance.handleVariableSettingAndVariableCalculations(commandLine3);
        assertEquals("{" + variableName + "=36}", tfl.getFieldValue(instance, "variablesAndValues"));
        
        instance.handleVariableSettingAndVariableCalculations(commandLine4);
        assertEquals("{" + variableName + "=30}", tfl.getFieldValue(instance, "variablesAndValues"));
        
        instance.handleVariableSettingAndVariableCalculations(commandLine5);
        assertEquals("{" + variableName + "=6}", tfl.getFieldValue(instance, "variablesAndValues"));
        
        instance.handleVariableSettingAndVariableCalculations(commandLine6);
        assertEquals("{" + variableName + "=10}", tfl.getFieldValue(instance, "variablesAndValues"));
        
    }

    /**
     * Test of createVariable method, of class SpecialCaseHandler.
     */
    @Test
    public void testCreateVariable() {
        System.out.println("createVariable");
        String rndName = tfl.createRandomString(0, true);
        int rndInt = tfl.getRndInt(Integer.MAX_VALUE);
        
        String rawData = rndName + "=" + rndInt;
        
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);
        instance.createVariable(rawData);
        
        if (instance.variablesAndValues.containsKey(rndName)) {
            if (instance.variablesAndValues.get(rndName) == rndInt) {
                assertTrue(true);
            } else {
                fail("Variable did not have the right value.");
            }
        } else {
            fail("Variable not found.");
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of handleFindColorAsParameter method, of class SpecialCaseHandler.
     */
    @Test
    public void testHandleFindColorAsParameter() {
        System.out.println("handleFindColorAsParameter");
        String commandLine = "setMousePos findColor #000000 0 0 40 40";
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);
        
        String result = instance.handleFindColorAsParameter(commandLine);
        
        String splitResult[] = result.split(" ");
        
        int xValue = Integer.parseInt(splitResult[0]);
        int yValue = Integer.parseInt(splitResult[1]);
        
        if(xValue < 0 || yValue < 0 || xValue > 40 || yValue > 40) {
            fail("Faulty coordinates");
        }
        
        String expResult = xValue + " " + yValue;
        
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isValidHex method, of class SpecialCaseHandler.
     */
    @Test
    public void testIsValidHex() {
        System.out.println("isValidHex");
        String hex = tfl.nextHexColor();
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();
        
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);
        boolean expResult = true;
        boolean result = instance.isValidHex(hex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
