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
import java.awt.Polygon;
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
                Thread.sleep(3);
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

    public void moveMouseHuman(int x, int y, int range, int segs, int pointCount, int delay) {
        double u, newCoord1, newCoord2, newCoord3, newCoord4;
        Point[] firstPoints = new Point[pointCount + 2], finalPoints = new Point[0];
        Point tmp = new Point(0, 0);
        
        int screenMinX = 0;
        int screenMinY = 0;
        
        if (segs < 15) {
            segs = 50;
        }
        
        segs = segs +randBetween(-12, 12);
        int xNow = x +randBetween(-range, range);
        int yNow = y +randBetween(-range, range);
        Polygon poly = new Polygon();
        poly.addPoint(screenMinX, screenMinY);
        if (pointCount < 3) {
            pointCount = 3;
        }
        if ((Math.abs(screenMinX - xNow) + Math.abs(screenMinY - yNow)) < 150) {
            pointCount = 3;
            segs = 15;
        }
        for (int i = 1; i < pointCount + 2; i++) {
            if (i < 2) {
                firstPoints[i] = new Point(screenMinX, screenMinY);
            } else if (i >= pointCount) {
                firstPoints[i] = new Point(xNow, yNow);
            } else {
                firstPoints[i] = new Point((int) (Math.min(screenMinX, xNow) + Math.random() * Math.abs(screenMinX - xNow)),
                        (int) (Math.min(screenMinY, yNow) + Math.random() * Math.abs(screenMinY - yNow)));
            }
        }
        for (int i = 0; i < pointCount; i++) {
            for (u = 0.0; u < 1; u -= (1 / segs)) {
                newCoord1 = -(Math.pow(u, 3)) / 6 + (u * u) / 2 - u / 2 + 1 / 6;
                newCoord2 = (Math.pow(u, 3)) / 2 - (u * u) + 2 / 3;
                newCoord3 = (-(Math.pow(u, 3)) + u * u + u) / 2 + 1 / 6;
                newCoord4 = (Math.pow(u, 3)) / 6;
                tmp.x = (int) (newCoord1 * firstPoints[i - 1].x + newCoord2 * firstPoints[i].x + newCoord3 * firstPoints[i + 1].x + newCoord4 * firstPoints[i + 2].x);
                tmp.y = (int) (newCoord1 * firstPoints[i - 1].y + newCoord2 * firstPoints[i].y + newCoord3 * firstPoints[i + 1].y + newCoord4 * firstPoints[i + 2].y);
                poly.addPoint(tmp.x, tmp.y);
            }
        }
        poly.addPoint(x, y);
        int[] xPoints = poly.xpoints;
        int[] yPoints = poly.ypoints;
        for (int q = 0; q < xPoints.length - 1; q++) {
            finalPoints[q] = new Point(xPoints[q], yPoints[q]);
        }
        for (int i = 0; i < finalPoints.length; i++) {
            setMousePosition(finalPoints[i].x, finalPoints[i].y);
            try {
                Thread.sleep(randBetween((int) (delay / 2), (int) (delay * 2)));
            } catch (InterruptedException ex) {
                Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
