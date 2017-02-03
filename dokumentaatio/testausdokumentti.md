Scanning for projects...
                                                                        
------------------------------------------------------------------------
Building MacroScript 1.0
------------------------------------------------------------------------

--- maven-clean-plugin:2.4.1:clean (default-clean) @ MacroScript ---
Deleting C:\Users\ZiiGaa\MacroScript\MacroScript\target

--- maven-resources-plugin:2.5:resources (default-resources) @ MacroScript ---
[debug] execute contextualize
Using 'UTF-8' encoding to copy filtered resources.
Copying 1 resource

--- maven-compiler-plugin:3.3:compile (default-compile) @ MacroScript ---
Changes detected - recompiling the module!
Compiling 5 source files to C:\Users\ZiiGaa\MacroScript\MacroScript\target\classes

--- maven-resources-plugin:2.5:testResources (default-testResources) @ MacroScript ---
[debug] execute contextualize
Using 'UTF-8' encoding to copy filtered resources.
skip non existing resourceDirectory C:\Users\ZiiGaa\MacroScript\MacroScript\src\test\resources

--- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ MacroScript ---
Changes detected - recompiling the module!
Compiling 5 source files to C:\Users\ZiiGaa\MacroScript\MacroScript\target\test-classes

--- maven-surefire-plugin:2.10:test (default-test) @ MacroScript ---
Surefire report directory: C:\Users\ZiiGaa\MacroScript\MacroScript\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running macroscript.macroscript.frmMainTest
getColorHexUnderCursor
loadFile
main
getColorUnderCursor
Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: javax.swing.plaf.FontUIResource cannot be cast to java.lang.Boolean
	at javax.swing.AbstractButton.setUIProperty(AbstractButton.java:2249)
	at javax.swing.LookAndFeel.installProperty(LookAndFeel.java:280)
	at javax.swing.plaf.synth.SynthButtonUI.updateStyle(SynthButtonUI.java:99)
	at javax.swing.plaf.synth.SynthButtonUI.installDefaults(SynthButtonUI.java:62)
	at javax.swing.plaf.synth.SynthArrowButton$SynthArrowButtonUI.installDefaults(SynthArrowButton.java:68)
	at javax.swing.plaf.basic.BasicButtonUI.installUI(BasicButtonUI.java:88)
	at javax.swing.JComponent.setUI(JComponent.java:663)
	at javax.swing.AbstractButton.setUI(AbstractButton.java:1810)
	at javax.swing.plaf.synth.SynthArrowButton.updateUI(SynthArrowButton.java:51)
	at javax.swing.AbstractButton.init(AbstractButton.java:2176)
	at javax.swing.JButton.<init>(JButton.java:137)
	at javax.swing.JButton.<init>(JButton.java:91)
	at javax.swing.plaf.synth.SynthArrowButton.<init>(SynthArrowButton.java:40)
	at javax.swing.plaf.synth.SynthScrollBarUI$1.<init>(SynthScrollBarUI.java:376)
	at javax.swing.plaf.synth.SynthScrollBarUI.createDecreaseButton(SynthScrollBarUI.java:376)
	at javax.swing.plaf.basic.BasicScrollBarUI.installComponents(BasicScrollBarUI.java:252)
	at javax.swing.plaf.basic.BasicScrollBarUI.installUI(BasicScrollBarUI.java:173)
	at javax.swing.JComponent.setUI(JComponent.java:663)
	at javax.swing.JScrollBar.setUI(JScrollBar.java:207)
	at javax.swing.JScrollBar.updateUI(JScrollBar.java:227)
	at javax.swing.JScrollBar.<init>(JScrollBar.java:161)
	at javax.swing.JScrollBar.<init>(JScrollBar.java:176)
	at javax.swing.JScrollPane$ScrollBar.<init>(JScrollPane.java:718)
	at javax.swing.JScrollPane.createHorizontalScrollBar(JScrollPane.java:814)
	at javax.swing.JScrollPane.<init>(JScrollPane.java:300)
	at javax.swing.JScrollPane.<init>(JScrollPane.java:351)
	at macroscript.macroscript.frmMain.initComponents(frmMain.java:50)
	at macroscript.macroscript.frmMain.<init>(frmMain.java:36)
	at macroscript.macroscript.frmMain$8.run(frmMain.java:438)
	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:311)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:744)
	at java.awt.EventQueue.access$400(EventQueue.java:97)
	at java.awt.EventQueue$3.run(EventQueue.java:697)
	at java.awt.EventQueue$3.run(EventQueue.java:691)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:714)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
	at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)
getColorPickerActive
setColors
saveAs
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.84 sec
Running macroscript.macroscript.KeyboardOperatorTest
keyDown
keyUp
type
getChar
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Running macroscript.macroscript.MacroScriptTest
main
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Running macroscript.macroscript.MouseOperatorTest
rightClick
leftClick
leftDown
rightHumanClick
moveMouseSmooth
rightDown
leftHumanClick
rightUp
leftUp
setMousePosition
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.163 sec
Running macroscript.macroscript.ScriptMotorTest
executeCommand
runScript
splitIntoLines
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec

Results :

Tests run: 26, Failures: 0, Errors: 0, Skipped: 0


--- maven-jar-plugin:2.3.2:jar (default-jar) @ MacroScript ---
Building jar: C:\Users\ZiiGaa\MacroScript\MacroScript\target\MacroScript-1.0.jar

--- maven-install-plugin:2.3.1:install (default-install) @ MacroScript ---
Installing C:\Users\ZiiGaa\MacroScript\MacroScript\target\MacroScript-1.0.jar to C:\Users\ZiiGaa\.m2\repository\macroscript\macroscript\MacroScript\1.0\MacroScript-1.0.jar
Installing C:\Users\ZiiGaa\MacroScript\MacroScript\pom.xml to C:\Users\ZiiGaa\.m2\repository\macroscript\macroscript\MacroScript\1.0\MacroScript-1.0.pom
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 23.874s
Finished at: Sat Feb 04 00:03:54 EET 2017
Final Memory: 14M/107M
------------------------------------------------------------------------