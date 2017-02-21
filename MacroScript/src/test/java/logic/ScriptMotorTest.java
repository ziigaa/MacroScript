/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import gui.frmLogger;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joonas
 */
public class ScriptMotorTest {

    private TestFunctionLibrary tfl = new TestFunctionLibrary();
    private frmLogger log = new frmLogger();
    
    public ScriptMotorTest() {
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
     * Test of runScript method, of class ScriptMotor.
     */
    @Test
    public void testRunScript() throws AWTException {
        System.out.println("runScript");
        ScriptMotor instance = new ScriptMotor("this\nis\nmy\nscript\n\n\n", log);
        instance.runScript();
        // kun loggeri lisätty, laita tähän skriptiks
        // pari oikeeta komentoo ja loput bogus
    }

    /**
     * Test of executeCommand method, of class ScriptMotor.
     */
    @Test
    public void testExecuteCommand() {

        String variableName = tfl.createRandomString(0, true);

        int variableValue = tfl.getRndInt(Integer.MAX_VALUE);

        System.out.println("executeCommand");
        String commandLine = "int " + variableName + "=" + variableValue;
        ScriptMotor instance;

        try {
            //getFieldValue(instance.getClass(), "variablesAndValues")
            instance = new ScriptMotor("this\nis\nmy\nscript", log);
            instance.executeCommand(commandLine);

            assertEquals("{" + variableName + "=" + variableValue + "}", tfl.getFieldValue(instance, "variablesAndValues"));

        } catch (AWTException ex) {
            Logger.getLogger(ScriptMotorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
