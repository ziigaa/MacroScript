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
    private HashMap<String, Integer> variablesAndValues;
    private ArrayList<String> colorPalette;
    private HashMap<String, Integer> theGoTos;
    //private ArrayList scriptVariableType;
    //private boolean stopPressed;
    private final MouseOperator mouseOperation;
    private final KeyboardOperator keyboardOperation;
    private ColorOperator colorOperation;
    private IfHandler ifHandler;

    public ScriptMotor(String inputScript) throws AWTException {
        this.theScript = inputScript;
        //this.currentCommand = "";
        this.currentLine = 0;
        this.lineCount = 0;
        this.theGoTos = new HashMap<>();
        this.theGoTos.clear();
        this.variablesAndValues = new HashMap<>();
        this.colorPalette = new ArrayList<>();
        this.theGoTos = new HashMap<>();
        this.mouseOperation = new MouseOperator();
        this.keyboardOperation = new KeyboardOperator();
        this.colorOperation = new ColorOperator();
        this.ifHandler = new IfHandler(variablesAndValues);
        runScript();
    }

    public void splitIntoLines(String splittable) {
        this.lines = splittable.split("\\r?\\n");
    }

    public void runScript() {

        this.variablesAndValues.clear();
        this.theGoTos.clear();
        this.colorPalette.clear();

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
            case "if"://todo: if findcolor bla bla bla keyup, keydown, type, humantype, keypress, setmousepos, movemousesmooth, movemousehuman
                executeCommand(ifHandler.handleIf(commandLine));
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
                this.colorPalette.clear();
                for (String tmp : this.command) {
                    if (!"colorPalette".equals(tmp)) {
                        if (tmp.length() == 7 && tmp.charAt(0) == '#') {
                            this.colorPalette.add(tmp);
                        } else {
                            //error, koska ei väri tai ei hex muodossa
                        }
                    }
                }
                break;
            case "int":
                if (variablesAndValues.containsKey(this.command[1])) {
                    //Anna errööör, koska muuttuja on jo olemassa
                } else {
                    String splByEq[] = this.command[1].split("=");
                    variablesAndValues.put(splByEq[0], Integer.parseInt(splByEq[1]));
                }
                break;
            case "mouseLeftDown":
                mouseOperation.leftDown();
                break;
            case "mm":

            //mouseOperation.moveMouseCurvy(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 5, 20, 5, 15);
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
                //todo: mahdollisuus välittää coords findcolorien avulla
                mouseOperation.setMousePosition(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]));
                break;
            case "moveMouseSmooth":
                //todo: mahdollisuus välittää coords findcolorien avulla
                mouseOperation.moveMouseSmooth(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 3);
                break;
            case "moveMouseHuman":
                //todo: mahdollisuus välittää coords findcolorien avulla
                mouseOperation.moveMouseHuman(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 50, 50);
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
//            case "findColor":
//                break;
//            case "findColorStartingFrom":
//                break;
            default:
                try {
                    String splittedByEqual[];
                    splittedByEqual = commandLine.split("=");
                    if (this.variablesAndValues.containsKey(splittedByEqual[0])) {
                        //laskutoimitusten varalta laita if splittedByEqual[1] ei ole int jne...
//                        int varIndex = scriptVariables.indexOf(splittedByEqual[0]);
//                        scriptVariables.set(varIndex, splittedByEqual[1]);
                        try {
                            variablesAndValues.put(splittedByEqual[0], Integer.parseInt(splittedByEqual[1]));
                        } catch (NumberFormatException e) {
                            //ei oo numero
                            if (variablesAndValues.containsKey(splittedByEqual[1])) {

                            }
                        } catch (NullPointerException e) {
                            //ei ollu mitää O.O
                        }

                    } else {

                        //erröööööör, ei oo tehty muuttujaa
                    }
                } catch (Exception e) {
                    //errööööör, ei voi splitata, joten tuntematon komento.
                }

                break;
        }
    }
}
