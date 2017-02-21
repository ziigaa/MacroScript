package logic;

import gui.frmLogger;
import operators.MouseOperator;
import operators.KeyboardOperator;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
//@author Joonas

public class ScriptMotor {

    private String theScript;
    private String lines[];
    private String command[];
    private int currentLine;
    private int lineCount;
    HashMap<String, Integer> variablesAndValues;
    private ArrayList<String> colorPalette;
    private HashMap<String, Integer> theGoTos;
    private final MouseOperator mouseOperation;
    private final KeyboardOperator keyboardOperation;
    private final SpecialCaseHandler specialCaseHandler;
    private frmLogger myLogger;

    public ScriptMotor(String inputScript, frmLogger myLogger) throws AWTException {
        this.theScript = inputScript;
        this.currentLine = 0;
        this.lineCount = 0;
        this.theGoTos = new HashMap<>();
        this.theGoTos.clear();
        this.variablesAndValues = new HashMap<>();
        this.colorPalette = new ArrayList<>();
        this.theGoTos = new HashMap<>();
        this.myLogger = myLogger;
        this.mouseOperation = new MouseOperator();
        this.keyboardOperation = new KeyboardOperator();
        this.specialCaseHandler = new SpecialCaseHandler(variablesAndValues, colorPalette, myLogger);

        runScript();
    }

    /**
     * Splits the given String into a string array and stores the array in a
     * private variable
     *
     * @param splittable The String to split
     */
    private void splitIntoLines(String splittable) {
        this.lines = splittable.split("\\r?\\n");
    }

    /**
     * Clears all relevant variables of data and forwards each line of the
     * script to the method executeCommand.
     */
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

    /**
     * Executes a line of code. All code is processed forward from here.
     *
     * @param commandLine The line of code to process
     */
    public void executeCommand(String commandLine) {
        this.command = commandLine.split(" ");
        String inExecution = this.command[0];

        if (commandLine.contains("3rror")) {
            return;
        }
        
        try {
            char firstChar = inExecution.charAt(0);
            if (firstChar == '@') {
                this.theGoTos.put(inExecution.substring(1, inExecution.length()), this.currentLine);
                return;
            }
        } catch (Exception e) {
            myLogger.insert("Syntax error: " + lines[currentLine]);
        }

        switch (inExecution) {
            case "if":
                System.out.println(specialCaseHandler.handleIf(commandLine));
                executeCommand(specialCaseHandler.handleIf(commandLine));
                break;
            case "goto":
                if (theGoTos.containsKey(this.command[1])) {
                    this.currentLine = this.theGoTos.get(this.command[1]);
                } else {
                    myLogger.insert("Label not found: " + commandLine);
                }
                break;
            case "sleep": {
                try {
                    Thread.sleep(Long.parseLong(this.command[1]));
                } catch (InterruptedException ex) {
                    Logger.getLogger(ScriptMotor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception e) {
                    myLogger.insert("Syntax error: " + commandLine);
                }
            }
            break;
            case "colorPalette":
                this.colorPalette.clear();
                for (String tmp : this.command) {
                    if (!"colorPalette".equals(tmp)) {
                        if (tmp.length() == 7 && tmp.charAt(0) == '#' && specialCaseHandler.isValidHex(tmp) == true) {
                            this.colorPalette.add(tmp);
                        } else {
                            myLogger.insert("Syntax error: " + commandLine + "\nInvalid color format. Use hex, t. ex. #000000\ncolorPalette has been emptied.");
                            //error, koska ei väri tai ei hex muodossa
                        }
                    }
                }
                break;
            case "int":
                specialCaseHandler.createVariable(this.command[1]);
                break;
            case "mouseLeftDown":
                mouseOperation.leftDown();
                break;
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
                try {
                    mouseOperation.setMousePosition(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]));
                } catch (NumberFormatException e) {
                    if (this.command[1].contains("findColor")) {
                        String colorPoint = specialCaseHandler.handleFindColorAsParameter(commandLine);
                        if (!colorPoint.contains("-1")) {
                            executeCommand(this.command[0] + " " + colorPoint);
                            return;
                        }
                    } else {
                        myLogger.insert("Syntax error: " + commandLine + "\nThe parameters need to be in numeric format or passed by a color finding method.");
                    }
                    //ei oo numero
                } catch (NullPointerException e) {
                    myLogger.insert("Syntax error: " + commandLine + "\nA parameter seems to be missing");
                    //ei ollu parametrii
                }
                break;
            case "moveMouseSmooth":
                try {
                    mouseOperation.moveMouseSmooth(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 3);
                } catch (NumberFormatException e) {
                    if (this.command[1].contains("findColor")) {
                        String colorPoint = specialCaseHandler.handleFindColorAsParameter(commandLine);
                        if (!colorPoint.contains("-1")) {
                            executeCommand(this.command[0] + " " + colorPoint);
                            return;
                        }
                    } else {
                        myLogger.insert("Syntax error: " + commandLine + "\nThe parameters need to be in numeric format or passed by a color finding method.");
                    }
                    //ei oo numero
                } catch (NullPointerException e) {
                    //ei ollu parametrii
                    myLogger.insert("Syntax error: " + commandLine + "\nA parameter seems to be missing");
                }
                break;
            case "moveMouseHuman":
                try {
                    mouseOperation.moveMouseHuman(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 50, 50);
                } catch (NumberFormatException e) {
                    if (this.command[1].contains("findColor")) {
                        String colorPoint = specialCaseHandler.handleFindColorAsParameter(commandLine);
                        if (!colorPoint.contains("-1")) {
                            executeCommand(this.command[0] + " " + colorPoint);
                            return;
                        }
                    } else {
                        myLogger.insert("Syntax error: " + commandLine + "\nThe parameters need to be in numeric format or passed by a color finding method.");
                    }
                    //ei oo numero
                } catch (NullPointerException e) {
                    myLogger.insert("Syntax error: " + commandLine + "\nA parameter seems to be missing");
                    //ei ollu parametrii
                }
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
            default:
                specialCaseHandler.handleVariableSettingAndVariableCalculations(commandLine);
                break;
        }
    }
}