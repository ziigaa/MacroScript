package macroscript.logic;

import macroscript.gui.frmLogger;
import macroscript.actions.MouseOperator;
import macroscript.actions.KeyboardOperator;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * All commands are processed here.
 *
 * @author Joonas
 */
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
    private final IfHandler ifHandler;
    private final FindColorOperator findColorOperation;
    private final VariableOperator variableOperation;
    private final frmLogger myLogger;

    /**
     * The constructor.
     *
     * @param inputScript The script to process
     * @param myLogger The parameter for the logger
     * @throws AWTException If the robots fail in any of the needed parts of the
     * program.
     */
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
        this.findColorOperation = new FindColorOperator(variablesAndValues, colorPalette, myLogger);
        this.ifHandler = new IfHandler(variablesAndValues, findColorOperation, myLogger);
        this.variableOperation = new VariableOperator(variablesAndValues, myLogger);
        
        
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

        if (commandLine.isEmpty()) {
            return;
        }

        if (commandLine.contains("3rror") && !commandLine.contains("type")) {
            if (this.command[0].equals("int")) {
                myLogger.insert("3rror is not allowed as a name for a variable");
            }
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
                //System.out.println(specialCaseHandler.handleIf(commandLine));
                executeCommand(ifHandler.handleIf(commandLine));
                break;
            case "goto":
                if (theGoTos.containsKey(this.command[1])) {
                    this.currentLine = this.theGoTos.get(this.command[1]);
                } else {
                    myLogger.insert("Label not found: " + commandLine);
                }

                break;
            case "sleep":
                try {
                    Thread.sleep(Long.parseLong(this.command[1]));
                } catch (InterruptedException ex) {
                    Logger.getLogger(ScriptMotor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception e) {
                    myLogger.insert("Syntax error: " + commandLine);
                }

                break;
            case "colorPalette":
                this.colorPalette.clear();
                for (String tmp : this.command) {
                    if (!"colorPalette".equals(tmp)) {
                        if (tmp.length() == 7 && tmp.charAt(0) == '#' && findColorOperation.isValidHex(tmp) == true) {
                            this.colorPalette.add(tmp);
                        } else {
                            myLogger.insert("Syntax error: " + commandLine + "\nInvalid color format. Use hex, t. ex. #000000\ncolorPalette has been emptied.");
                            //error, koska ei väri tai ei hex muodossa
                        }
                    }
                }
                break;
            case "int":
                variableOperation.createVariable(this.command[1]);
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
                        String colorPoint = findColorOperation.handleFindColorAsParameter(commandLine);
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
                } catch (Exception e) {
                    myLogger.insert("Syntax error: " + commandLine);
                }
                break;
            case "moveMouseSmooth":
                try {
                    mouseOperation.moveMouseSmooth(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 3);
                } catch (NumberFormatException e) {
                    if (this.command[1].contains("findColor")) {
                        String colorPoint = findColorOperation.handleFindColorAsParameter(commandLine);
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
                } catch (Exception e) {
                    myLogger.insert("Syntax error: " + commandLine);
                }
                break;
            case "moveMouseHuman":
                try {
                    mouseOperation.moveMouseHuman(Integer.parseInt(this.command[1]), Integer.parseInt(this.command[2]), 50, 50);
                } catch (NumberFormatException e) {
                    if (this.command[1].contains("findColor")) {
                        String colorPoint = findColorOperation.handleFindColorAsParameter(commandLine);
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
                } catch (Exception e) {
                    myLogger.insert("Syntax error: " + commandLine);
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
            case "pressEnter":
                keyboardOperation.pressEnter(true);
                break;
            default:
                variableOperation.handleVariableSettingAndVariableCalculations(commandLine);
                break;
        }
    }
}
