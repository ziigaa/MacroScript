/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The mouse functions are executed here.
 *
 * @author Joonas
 */
public class MouseOperator {

    private Robot bot;

    /**
     * The constructor.
     *
     * @throws AWTException If the Robot fails.
     */
    public MouseOperator() throws AWTException {
        this.bot = new Robot();
    }

    /**
     * Simulates a mouse left button down event.
     */
    public void leftDown() {
        bot.mousePress(InputEvent.BUTTON1_MASK);
    }

    /**
     * Simulates a mouse left button up event.
     */
    public void leftUp() {
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**
     * Simulates a mouse left click.
     */
    public void leftClick() {
        leftDown();
        leftUp();
    }

    /**
     * Simulates a mouse right button down event.
     */
    public void rightDown() {
        bot.mousePress(InputEvent.BUTTON3_MASK);
    }

    /**
     * Simulates a mouse right button up event.
     */
    public void rightUp() {
        bot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    /**
     * Adds a Thread.sleep() of a fixed value specified with a parameter.
     *
     * @param delay The time to sleep as milliseconds.
     */
    private void sleepDelay(int delay) {
        long sInterval = (long) delay;

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a Thread.sleep() with a randomized time between 0 and 30 ms.
     */
    private void sleepRnd() {
        long sInterval = 10;
        Random rnd = new Random();

        sInterval = (long) rnd.nextInt(30);

        try {
            Thread.sleep(sInterval);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Simulates a mouse left click with random Thread.sleep() intervals before
     * left down event, in between of left down and left up events and after
     * left down event.
     */
    public void leftHumanClick() {
        sleepRnd();
        leftDown();

        sleepRnd();
        leftUp();

        sleepRnd();
    }

    /**
     * Simulates a mouse right click.
     */
    public void rightClick() {
        rightDown();
        rightUp();
    }

    /**
     * Simulates a mouse right click with random Thread.sleep() intervals before
     * left down event, in between of left down and left up events and after
     * left down event.
     */
    public void rightHumanClick() {
        sleepRnd();
        rightDown();

        sleepRnd();
        rightUp();

        sleepRnd();
    }

    /**
     * Sets the cursor position immediately to gives coordinates.
     *
     * @param x The horizontal target coordinate
     * @param y The vertical target coordinate
     */
    public void setMousePosition(int x, int y) {
        bot.mouseMove(x, y);
    }

    /**
     * Moves the cursor pixel by pixel to the given coordinates using the
     * shortest path availible. Can only move either horizontally, vertically or
     * diagonally, where delta x and delta y both equal one pixel.
     *
     * @param x The horizontal target coordinate
     * @param y The vertical target coordinate
     * @param delay The delay in ms between each move
     */
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
            sleepDelay(delay);
            setMousePosition(xNow, yNow);
        }

    }

    /**
     * Randomises an integer number between the parameter low and the parameter
     * high.
     *
     * @param low The smallest number to return.
     * @param high The highest number to return.
     * @return A random integer within the specified parameters.
     */
    private Integer randBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    /**
     * Moves the cursor using a curvy route to get to the given coordinates.
     * Also skips pixels inbetween moves, simulating normal cursor behaviour.
     *
     * @param x The horizontal target coordinate
     * @param y The vertical target coordinate
     * @param steps The amount of steps that will be used to reach the target
     * coordinates
     * @param arch Determines the boldness of the curves that will become the
     * route to reach the target coordinates
     */
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
            sleepDelay(delay);
        }

        pntNow = pointInfo.getLocation();
        if (Math.abs(pntNow.x - x) > 3 || Math.abs(pntNow.y - y) > 3) {
            moveMouseSmooth(x + randBetween(-3, 3), y + randBetween(-3, 3), 7);
        }
    }
}
