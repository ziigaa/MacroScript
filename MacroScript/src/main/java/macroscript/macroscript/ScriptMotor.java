/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroscript.macroscript;

/**
 *
 * @author Joonas <>
 */
public class ScriptMotor {

    public String currentCommand;
    public String theScript;
    public String lines[];
    public String command[];

    public ScriptMotor(String inputScript) {
        this.theScript = inputScript;
        this.currentCommand = "";
    }

    public void splitIntoLines(String splittable) {
        this.lines = splittable.split("\\r?\\n");
    }

    public void runScript() {

    }

    public void executeCommand(String commandLine) {
        this.command = commandLine.split(" ");
        String inExecution = this.command[0];

        char firstChar = inExecution.charAt(0);

        if (firstChar == '@') {
            return;
        }

        switch (inExecution) {
            case "if":
            case "goto":
            case "sleep":
            case "colorPalette":
            case "int":
            case "mouseLeftDown":
            case "mouseLeftUp":
            case "mouseRightDown":
            case "mouseRightUp":
            case "setMousePos":
            case "moveMouseSmooth":
            case "moveMouseHuman":
            case "mouseLeftClick":
            case "mouseRightClick":
            case "mouseHumanLeftClick":
            case "mouseHumanRightClick":
            case "keyDown":
            case "keyUp":
            case "type":
            case "typeHuman":
            case "findColorOnScreen":
        }
    }
}
