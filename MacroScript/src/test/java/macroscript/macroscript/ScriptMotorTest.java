/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

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
public class ScriptMotorTest {
    
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
     * Test of splitIntoLines method, of class ScriptMotor.
     */
    @Test
    public void testSplitIntoLines() {
        System.out.println("splitIntoLines");
        String splittable = "";
        ScriptMotor instance = null;
        instance.splitIntoLines(splittable);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of runScript method, of class ScriptMotor.
     */
    @Test
    public void testRunScript() {
        System.out.println("runScript");
        ScriptMotor instance = null;
        instance.runScript();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executeCommand method, of class ScriptMotor.
     */
    @Test
    public void testExecuteCommand() {
        System.out.println("executeCommand");
        String commandLine = "";
        ScriptMotor instance = null;
        instance.executeCommand(commandLine);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}