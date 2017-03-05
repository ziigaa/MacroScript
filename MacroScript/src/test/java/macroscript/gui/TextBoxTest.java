/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Joonas
 */
public class TextBoxTest extends JFrame {

    private JTextArea testArea;
    private KeyEvent keyEventNow;
    private final Robot fixBot;

    public TextBoxTest() throws AWTException {

        this.testArea = new JTextArea(6, 20);
        testArea.setText("");
        JScrollPane scrollingArea = new JScrollPane(testArea);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(scrollingArea, BorderLayout.CENTER);

        this.setContentPane(content);
        this.setTitle("TextBoxTest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        fixBot = new Robot();

        testArea.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                keyEventNow = ke;
                //ke.consume();
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                keyEventNow = ke;
                //ke.consume();
                fixBot.keyRelease(ke.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                keyEventNow = ke;
                //ke.consume();
            }
        });
    }

    public char returnKeyEventAsChar() {
        return keyEventNow.getKeyChar();
    }

    public void requestFocusForTextArea() {
        testArea.requestFocus();
    }

    public String getTestText() {
        return testArea.getText();
    }
}
