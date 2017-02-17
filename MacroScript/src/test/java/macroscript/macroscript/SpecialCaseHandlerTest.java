/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

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
        variablesAndValues.put("i", 3);
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues);
        String ifSentence = "if i=3 setMousePos 1 1";
        String expResult = "setMousePos 1 1";
        String result = instance.handleIf(ifSentence);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createVariable method, of class SpecialCaseHandler.
     * AND
     * Test of handleVariableSettingAndVariableCalculations method, of class SpecialCaseHandler.
     */
    @Test
    public void testCreateVariableAndHandleVariableSettingAndVariableCalculations() {
        
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        SpecialCaseHandler instance = new SpecialCaseHandler(variablesAndValues);
        
        System.out.println("handleVariableSettingAndVariableCalculations");
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
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
