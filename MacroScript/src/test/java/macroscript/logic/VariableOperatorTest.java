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
public class VariableOperatorTest {

    private final TestFunctionLibrary tfl = new TestFunctionLibrary();
    private final frmLogger myLogger = new frmLogger();
    HashMap<String, Integer> variablesAndValues = new HashMap<>();
    ArrayList<String> colorPalette = new ArrayList<>();

    public VariableOperatorTest() {
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
     * Test of handleVariableSettingAndVariableCalculations method, of class
     * VariableOperator.
     */
    @Test
    public void testHandleVariableSettingAndVariableCalculations() {
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();

        VariableOperator instance = new VariableOperator(variablesAndValues, myLogger);

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
     * Test of createVariable method, of class VariableOperator.
     */
    @Test
    public void testCreateVariable() {

        System.out.println("createVariable");
        String rndName = tfl.createRandomString(0, true);
        int rndInt = tfl.getRndInt(Integer.MAX_VALUE);

        String rawData = rndName + "=" + rndInt;

        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        ArrayList<String> colorPalette = new ArrayList<>();

        VariableOperator instance = new VariableOperator(variablesAndValues, myLogger);
        instance.createVariable(rawData);

        assertEquals("{" + rndName + "=" + rndInt + "}", tfl.getFieldValue(instance, "variablesAndValues"));
    }

}
