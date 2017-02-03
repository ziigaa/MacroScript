Scanning for projects...
                                                                        
------------------------------------------------------------------------
Building MacroScript 1.0
------------------------------------------------------------------------

--- pitest-maven:1.1.8:mutationCoverage (default-cli) @ MacroScript ---
Found plugin : Default csv report plugin
Found plugin : Default xml report plugin
Found plugin : Default html report plugin
Found plugin : Default limit mutations plugin
Found shared classpath plugin : Default mutation engine
Adding org.pitest:pitest to SUT classpath
Mutating from C:\Users\ZiiGaa\MacroScript\MacroScript\target\classes
Defaulting to group id (macroscript.macroscript*)
0:01:24 PIT >> INFO : Verbose logging is disabled. If you encounter an problem please enable it before reporting an issue.
0:01:26 PIT >> INFO : Sending 5 test classes to minion
0:01:26 PIT >> INFO : Sent tests to minion
0:01:26 PIT >> INFO : MINION : 0:01:26 PIT >> INFO : Checking environment

0:01:26 PIT >> INFO : MINION : 0:01:26 PIT >> INFO : Found  5 tests

0:01:26 PIT >> INFO : MINION : 0:01:26 PIT >> INFO : Dependency analysis reduced number of potential tests by 0

0:01:26 PIT >> INFO : MINION : 0:01:26 PIT >> INFO : 5 tests received

0:01:27 PIT >> INFO : MINION : 0:01:27 PIT >> WARNING : More threads at end of test (8) macroscript.macroscript.KeyboardOperatorTest than start. (5)

0:01:56 PIT >> INFO : MINION : 0:01:56 PIT >> WARNING : More threads at end of test (12) macroscript.macroscript.frmMainTest than start. (7)

|0:01:56 PIT >> WARNING : Description [testClass=macroscript.macroscript.frmMainTest, name=macroscript.macroscript.frmMainTest] did not pass without mutation.
/0:01:56 PIT >> INFO : Calculated coverage in 31 seconds.
------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
Total time: 40.722s
Finished at: Sat Feb 04 00:01:56 EET 2017
Final Memory: 11M/155M
------------------------------------------------------------------------
Failed to execute goal org.pitest:pitest-maven:1.1.8:mutationCoverage (default-cli) on project MacroScript: Execution default-cli of goal org.pitest:pitest-maven:1.1.8:mutationCoverage failed: All tests did not pass without mutation when calculating line coverage. Mutation testing requires a green suite.
See http://pitest.org for more details.
-> [Help 1]

To see the full stack trace of the errors, re-run Maven with the -e switch.
Re-run Maven using the -X switch to enable full debug logging.

For more information about the errors and possible solutions, please read the following articles:
[Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginExecutionException