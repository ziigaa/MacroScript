Scanning for projects...
                                                                        
------------------------------------------------------------------------
Building MacroScript 1.0
------------------------------------------------------------------------

--- maven-resources-plugin:2.5:resources (default-resources) @ MacroScript ---
[debug] execute contextualize
Using 'UTF-8' encoding to copy filtered resources.
Copying 1 resource

--- maven-compiler-plugin:3.3:compile (default-compile) @ MacroScript ---
Nothing to compile - all classes are up to date

--- maven-resources-plugin:2.5:testResources (default-testResources) @ MacroScript ---
[debug] execute contextualize
Using 'UTF-8' encoding to copy filtered resources.
skip non existing resourceDirectory C:\Users\ZiiGaa\MacroScript\MacroScript\src\test\resources

--- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ MacroScript ---
Nothing to compile - all classes are up to date

--- maven-surefire-plugin:2.10:test (default-test) @ MacroScript ---
Surefire report directory: C:\Users\ZiiGaa\MacroScript\MacroScript\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running macroscript.actions.ColorOperatorTest
findColorFromPalette
findColorStartingFromPoint
java.awt.Point[x=33,y=29]
findColorFromPaletteStartingFromPoint
hexToRGB
findColor
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.351 sec
Running macroscript.actions.KeyboardOperatorTest
keyDown
keyUp
type
typeChar
pressEnter
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec
Running macroscript.actions.MouseOperatorTest
rightClick
leftClick
leftDown
rightHumanClick
moveMouseSmooth
rightDown
leftHumanClick
rightUp
moveMouseHuman
leftUp
setMousePosition
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.106 sec
Running macroscript.gui.frmMainTest
getColorHexUnderCursor
getColorUnderCursor
getColorPickerActive
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.293 sec
Running macroscript.logic.FindColorOperatorTest
handleFindColorAsParameter
23 7
isValidHex
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 sec
Running macroscript.logic.IfHandlerTest
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
handleIf
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Running macroscript.logic.ScriptMotorTest
executeCommand
runScript
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec
Running macroscript.logic.VariableOperatorTest
createVariable
testCreateVariableAndHandleVariableSettingAndVariableCalculations
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 sec

Results :

Tests run: 31, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 5.334s
Finished at: Fri Feb 24 21:54:36 EET 2017
Final Memory: 12M/223M
------------------------------------------------------------------------
