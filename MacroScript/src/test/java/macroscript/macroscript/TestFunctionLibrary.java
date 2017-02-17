/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.awt.AWTException;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author Joonas <>
 */
public class TestFunctionLibrary {

    private Random rnd = new Random();

    public String createRandomString(int length, boolean rndLength) {

        if (rndLength == true) {
            length = rnd.nextInt(10) + 1;
        }

        String alphas = "abcdefghijklmnopqrstuvwxyz";

        char[] generatedName = new char[length];

        for (int i = 0; i < length; i++) {
            generatedName[i] = alphas.charAt(rnd.nextInt(alphas.length()));
        }

        return new String(generatedName);
    }

    public Integer getRndInt(int maxValue) {
        return rnd.nextInt(maxValue);
    }

    //getFieldValue(instance.getClass(), "variablesAndValues");
    public String getFieldValue(Object instance, String fieldName) {

        try {
            Class<?> classToInspect = instance.getClass();

            Field fields[] = classToInspect.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);

                try {

                    String fieldToString = field.get(instance).toString();

                    if (field.getName().equals(fieldName)) {
                        return fieldToString;
                    }

                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ScriptMotorTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ScriptMotorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "3rror"; //3rror siksi, ettei se voi olla mikään generoitu arvo..
    }
}
