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
 * @author Joonas <>
 */
public class IfHandlerTest {
    
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
        System.out.println("handleIf");
        HashMap<String, Integer> variablesAndValues = new HashMap<>();
        variablesAndValues.put("i", 3);
        IfHandler instance = new IfHandler(variablesAndValues);
        String ifSentence = "if i=3 setMousePos 1 1";
        String expResult = "setMousePos 1 1";
        String result = instance.handleIf(ifSentence);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
