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
Running macroscript.macroscript.frmMainTest
getColorHexUnderCursor
loadFile
main
getColorUnderCursor
Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: javax.swing.plaf.nimbus.DerivedColor$UIResource cannot be cast to java.awt.Font
	at javax.swing.plaf.nimbus.NimbusStyle.getFontForState(NimbusStyle.java:573)
	at javax.swing.plaf.synth.SynthStyle.installDefaults(SynthStyle.java:933)
	at javax.swing.plaf.nimbus.NimbusStyle.installDefaults(NimbusStyle.java:231)
	at javax.swing.plaf.synth.SynthStyle.installDefaults(SynthStyle.java:916)
	at javax.swing.plaf.synth.SynthLookAndFeel.updateStyle(SynthLookAndFeel.java:265)
	at javax.swing.plaf.synth.SynthPanelUI.updateStyle(SynthPanelUI.java:117)
	at javax.swing.plaf.synth.SynthPanelUI.installDefaults(SynthPanelUI.java:100)
	at javax.swing.plaf.basic.BasicPanelUI.installUI(BasicPanelUI.java:56)
	at javax.swing.plaf.synth.SynthPanelUI.installUI(SynthPanelUI.java:62)
	at javax.swing.JComponent.setUI(JComponent.java:663)
	at javax.swing.JPanel.setUI(JPanel.java:153)
	at javax.swing.JPanel.updateUI(JPanel.java:126)
	at javax.swing.JPanel.<init>(JPanel.java:86)
	at javax.swing.JPanel.<init>(JPanel.java:109)
	at javax.swing.JPanel.<init>(JPanel.java:117)
	at javax.swing.JRootPane.createContentPane(JRootPane.java:521)
	at javax.swing.JRootPane.<init>(JRootPane.java:368)
	at javax.swing.JFrame.createRootPane(JFrame.java:278)
	at javax.swing.JFrame.frameInit(JFrame.java:259)
	at javax.swing.JFrame.<init>(JFrame.java:182)
	at macroscript.macroscript.frmMain.initComponents(frmMain.java:48)
	at macroscript.macroscript.frmMain.<init>(frmMain.java:33)
	at macroscript.macroscript.frmMain$7.run(frmMain.java:419)
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
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.246 sec
Running macroscript.macroscript.MacroScriptTest
main
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running macroscript.macroscript.ScriptMotorTest
executeCommand
runScript
splitIntoLines
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec

Results :

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 5.604s
Finished at: Fri Jan 20 22:31:00 EET 2017
Final Memory: 9M/155M
------------------------------------------------------------------------
