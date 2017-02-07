/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public void moveMouseSmooth(int x, int y, int delay) {
        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        int xNow = (int) pntNow.x;
        int yNow = (int) pntNow.y;

        while (xNow != x || yNow != y) {
            if (yNow < y) {
                yNow++;
            }
            if (xNow < x) {
                xNow++;
            }
            if (yNow > y) {
                yNow--;
            }
            if (xNow > x) {
                xNow--;
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
            setMousePosition(xNow, yNow);
        }

    }

    private Integer randBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public void moveMouseHuman(int x, int y, int steps, int arch) {
        int targetX, targetY, tmpX, tmpY, negateX, negateY, delay;
        double rnd1, rnd2, arch1, arch2, stepProcess;

        PointerInfo pointInfo = MouseInfo.getPointerInfo();
        Point pntNow = pointInfo.getLocation();
        int curX = (int) pntNow.x;
        int curY = (int) pntNow.y;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        targetX = x + randBetween(-3, 3);
        targetY = y + randBetween(-3, 3);
        rnd1 = Math.random() * 5;
        rnd2 = Math.random() * 5;
        arch1 = Math.random() * arch;
        arch2 = Math.random() * arch;
        delay = 15;

        if (curX > targetX) {
            negateX = 1;
        } else {
            negateX = -1;
        }
        if (curY > targetY) {
            negateY = 1;
        } else {
            negateY = -1;
        }

        for (int i = 1; i < steps; i++) {
            stepProcess = (double) i / steps;
            tmpX = (int) (curX + (targetX - curX) * stepProcess + (negateX * Math.sin(Math.PI * rnd1 * stepProcess) * arch1));
            tmpY = (int) (curY + (targetY - curY) * stepProcess + (negateY * Math.sin(Math.PI * rnd2 * stepProcess) * arch2));
            if (tmpX < 0) {
                tmpX = randBetween(0, 3);
            }
            if (tmpY < 0) {
                tmpY = randBetween(0, 3);
            }
            if (tmpX > screenWidth) {
                tmpX = screenWidth + randBetween(-3, 0);
            }
            if (tmpY > screenHeight) {
                tmpY = screenHeight + randBetween(-3, 0);
            }
            setMousePosition(tmpX, tmpY);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        pntNow = pointInfo.getLocation();
        if (Math.abs(pntNow.x - x) > 3 || Math.abs(pntNow.y - y) > 3) {
            moveMouseSmooth(x + randBetween(-3, 3), y + randBetween(-3, 3), 7);
        }
    }
}
