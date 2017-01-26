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
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas <>
 */
public class MouseOperator {

    private Robot bot;

    public MouseOperator() throws AWTException {
        this.bot = new Robot();
    }

    public void leftDown() {
        bot.mousePress(InputEvent.BUTTON1_MASK);
    }

    public void leftUp() {
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void leftClick() {
        leftDown();
        leftUp();
    }

    public void rightDown() {
        bot.mousePress(InputEvent.BUTTON2_MASK);
    }

    public void rightUp() {
        bot.mouseRelease(InputEvent.BUTTON2_MASK);
    }

    public void leftHumanClick() {

        long sInterval = 10;
        Random rnd = new Random();

        sInterval = (long) rnd.nextInt(30);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sInterval = (long) rnd.nextInt(30);
        leftDown();

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

        sInterval = (long) rnd.nextInt(30);
        leftUp();

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rightClick() {
        rightDown();
        rightUp();
    }

    public void rightHumanClick() {
        long sInterval = 10;
        Random rnd = new Random();

        sInterval = (long) rnd.nextInt(30);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

        sInterval = (long) rnd.nextInt(30);
        rightDown();

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }

        sInterval = (long) rnd.nextInt(30);
        rightUp();

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMousePosition(int x, int y) {
        bot.mouseMove(x, y);
    }

    public void moveMouseSmooth(int x, int y) {

        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        int beginX = (int) pntNow.getX();
        int beginY = (int) pntNow.getY();
        
        
    }
}
