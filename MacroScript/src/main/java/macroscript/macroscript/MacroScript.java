/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas
 */
public class MacroScript {

    /**
     * Creates the main window and starts the Timer responsible for updating the
     * mouse coordinates and the color picking feature on the main form.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmMain mainWindow = new frmMain();
        mainWindow.setVisible(true);

        Timer tmrCursorPosition = new Timer();

        tmrCursorPosition.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                PointerInfo pointInfo = MouseInfo.getPointerInfo();
                Point pntNow = pointInfo.getLocation();
                int x = (int) pntNow.getX();
                int y = (int) pntNow.getY();

                mainWindow.lblXpos.setText(String.valueOf(x));
                mainWindow.lblYpos.setText(String.valueOf(y));

                if (mainWindow.getColorPickerActive() == true) {
                    try {
                        mainWindow.setColors();
                    } catch (AWTException ex) {
                        Logger.getLogger(MacroScript.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }, /*run first occurrence immediately at 0ms*/ 0, 100); //rerun after every 100ms
    }

}
