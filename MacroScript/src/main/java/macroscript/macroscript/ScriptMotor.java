/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas <>
 */
public class ScriptMotor {

    //private String currentCommand;
    private String theScript;
    private String lines[];
    private String command[];
    private int currentLine;
    private int lineCount;
    private ArrayList<String> scriptVariables;
    private ArrayList<Integer> scriptVariableValues;
    private HashMap<String, Integer> theGoTos;
    //private ArrayList scriptVariableType;
    //private boolean stopPressed;
    private final MouseOperator mouseOperation;
    private final KeyboardOperator keyboardOperation;

    public ScriptMotor(String inputScript) throws AWTException {
        this.theScript = inputScript;
        //this.currentCommand = "";
        this.currentLine = 0;
        this.lineCount = 0;
        this.theGoTos = new HashMap<>();
        this.theGoTos.clear();
        this.scriptVariables = new ArrayList<>();
        this.scriptVariableValues = new ArrayList<>();
        this.theGoTos = new HashMap<>();
        this.mouseOperation = new MouseOperator();
        this.keyboardOperation = new KeyboardOperator();
        runScript();
    }

    public void splitIntoLines(String splittable) {
        this.lines = splittable.split("\\r?\\n");
    }

    public void runScript() {

        this.scriptVariableValues.clear();
        this.scriptVariables.clear();
        this.theGoTos.clear();

        splitIntoLines(this.theScript);

        this.lineCount = 0;
        for (int i = 0; i < this.lines.length; i++) {
            if (this.lines[i] != null) {
                lineCount++;
            }
        }

        while (currentLine < lineCount) { // && stopPressed == false) {
            executeCommand(this.lines[currentLine]);
            currentLine++;
        }
    }

    public void executeCommand(String commandLine) {
        this.command = commandLine.split(" ");
        String inExecution = this.command[0];

        char firstChar = inExecution.charAt(0);

        if (firstChar == '@') {
            this.theGoTos.put(inExecution.substring(1, inExecution.length()), this.currentLine);
            return;
        }

        switch (inExecution) {
            case "if":
                break;
            case "goto":
                this.currentLine = this.theGoTos.get(this.command[1]);
                break;
            case "sleep": {
                try {
                    Thread.sleep(Long.parseLong(this.command[1]));
                } catch (InterruptedException ex) {
                    Logger.getLogger(ScriptMotor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "colorPalette":
                break;
            case "int":
                if (scriptVariables.contains(this.command[1])) {
                    //Anna errööör
                } else {
                    String splByEq[] = this.command[1].split("=");
                    scriptVariables.add(splByEq[0]);
                    scriptVariableValues.add(Integer.parseInt(splByEq[1]));
                }
                break;
            case "mouseLeftDown":
                mouseOperation.leftDown();
                break;
            case "mm":
            //keyboardOperation.typeString("äöå");
            case "mouseLeftUp":
                mouseOperation.leftUp();
                break;
            case "mouseRightDown":
                mouseOperation.rightDown();
                break;
            case "mouseRightUp":
                mouseOperation.rightUp();
                break;
            case "setMousePos":
                mouseOperation.setMousePosition(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]));
                break;
            case "moveMouseSmooth":
                mouseOperation.moveMouseSmooth(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]));
                break;
            case "moveMouseHuman":
                mouseOperation.moveMouseHuman(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]));
                break;
            case "mouseLeftClick":
                mouseOperation.leftClick();
                break;
            case "mouseRightClick":
                mouseOperation.rightClick();
                break;
            case "mouseHumanLeftClick":
                mouseOperation.leftHumanClick();
                break;
            case "mouseHumanRightClick":
                mouseOperation.rightHumanClick();
                break;
            case "keyDown":
                keyboardOperation.keyDown(this.command[1].charAt(0));
                break;
            case "keyUp":
                keyboardOperation.keyUp(this.command[1].charAt(0));
                break;
            case "type":
                keyboardOperation.type(commandLine.substring(5), false);
                break;
            case "typeHuman":
                keyboardOperation.type(commandLine.substring(10), true);
                break;
            case "findColorOnScreen":
                break;
            default:
                try {
                    String splittedByEqual[];
                    splittedByEqual = commandLine.split("=");
                    if (this.scriptVariables.contains(splittedByEqual[0])) {
                        //laskutoimitusten varalta laita if splittedByEqual[1] ei ole int jne...
                        int varIndex = scriptVariables.indexOf(splittedByEqual[0]);
                        scriptVariables.set(varIndex, splittedByEqual[1]);
                    } else {
                        //erröööööör
                    }
                } catch (Exception e) {
                    //errööööör
                }

                break;
        }
    }
}
