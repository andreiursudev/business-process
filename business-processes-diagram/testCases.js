var testCase1 = {"testCaseName":"callMethod1","methodExecution":{"methodName":"Object1_method1","input":{"value":"value"},"output":"value 1 ","children":[]}}
var testCase2 = {"testCaseName":"callMethod2Scenario1","methodExecution":{"methodName":"Object1_method2","input":{"value":"value1"},"output":"value1 2 ","children":[]}}
var testCase3 = {"testCaseName":"callMethod2Scenario2","methodExecution":{"methodName":"Object1_method2","input":{"value":"value2"},"output":"value2 2 ","children":[]}}
var testCase4 = {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","input":{"value":"value1"},"output":"value1 1 value1 2 ","children":[{"methodName":"Object2_method2","input":{"value":"value1"},"output":"value1 2 ","children":[]}]}}
var testCase5 = {"testCaseName":"methodCallsAnotherMethodScenario2","methodExecution":{"methodName":"Object2_method1","input":{"value":"value2"},"output":"value2 1 value2 2 ","children":[{"methodName":"Object2_method2","input":{"value":"value2"},"output":"value2 2 ","children":[]}]}}
var testCase6 = {"testCaseName":"methodCallsTwoOtherMethodsScenario1","methodExecution":{"methodName":"Object2_method3","input":{"value":"value1"},"output":"value1 3 value1 4 value1 5 ","children":[{"methodName":"Object2_method4","input":{"value":"value1"},"output":"value1 4 ","children":[]},{"methodName":"Object2_method5","input":{"value":"value1"},"output":"value1 5 ","children":[]}]}}
var testCase7 = {"testCaseName":"methodCallsTwoOtherMethodsScenario2","methodExecution":{"methodName":"Object2_method3","input":{"value":"value2"},"output":"value2 3 value2 4 value2 5 ","children":[{"methodName":"Object2_method4","input":{"value":"value2"},"output":"value2 4 ","children":[]},{"methodName":"Object2_method5","input":{"value":"value2"},"output":"value2 5 ","children":[]}]}}
var testCase8 = {"testCaseName":"conditionalMethodCallTrue","methodExecution":{"methodName":"Object3_method1","input":{"value":"valueTrue"},"output":"valueTrue 1 valueTrue 2 ","children":[{"methodName":"Object3_method2","input":{"value":"valueTrue"},"output":"valueTrue 2 ","children":[]}]}}
var testCase9 = {"testCaseName":"conditionalMethodCallFalse","methodExecution":{"methodName":"Object3_method1","input":{"value":"valueFalse"},"output":"valueFalse 1 valueFalse 3 ","children":[{"methodName":"Object3_method3","input":{"value":"valueFalse"},"output":"valueFalse 3 ","children":[]}]}}
var testCase10 = {"testCaseName":"methodCallsInnerMethod","methodExecution":{"methodName":"Object4_method1","input":{"value":"value1"},"output":"value1 1 value1 2 value1 3 ","children":[{"methodName":"Object4_method2","input":{"value":"value1"},"output":"value1 2 value1 3 ","children":[{"methodName":"Object4_method3","input":{"value":"value1"},"output":"value1 3 ","children":[]}]}]}}
var testCase11 = {"testCaseName":"complexMethodCallScenario1","methodExecution":{"methodName":"Object5_method1","input":{"value":"valueTrue"},"output":"valueTrue 1 valueTrue 2 valueTrue 3 valueTrue 4 valueTrue 7 valueTrue 71 valueTrue 72 valueTrue 73 valueTrue 74 valueTrue 75 valueTrue 77 valueTrue 6 ","children":[{"methodName":"Object5_method2","input":{"value":"valueTrue"},"output":"valueTrue 2 ","children":[]},{"methodName":"Object5_method3","input":{"value":"valueTrue"},"output":"valueTrue 3 ","children":[]},{"methodName":"Object5_method4","input":{"value":"valueTrue"},"output":"valueTrue 4 ","children":[]},{"methodName":"Object5_method7","input":{"value":"valueTrue"},"output":"valueTrue 7 valueTrue 71 valueTrue 72 valueTrue 73 valueTrue 74 valueTrue 75 valueTrue 77 ","children":[{"methodName":"Object5_method71","input":{"value":"valueTrue"},"output":"valueTrue 71 ","children":[]},{"methodName":"Object5_method72","input":{"value":"valueTrue"},"output":"valueTrue 72 valueTrue 73 valueTrue 74 valueTrue 75 valueTrue 77 ","children":[{"methodName":"Object5_method73","input":{"value":"valueTrue"},"output":"valueTrue 73 ","children":[]},{"methodName":"Object5_method74","input":{"value":"valueTrue"},"output":"valueTrue 74 ","children":[]},{"methodName":"Object5_method75","input":{"value":"valueTrue"},"output":"valueTrue 75 ","children":[]},{"methodName":"Object5_method77","input":{"value":"valueTrue"},"output":"valueTrue 77 ","children":[]}]}]},{"methodName":"Object5_method6","input":{"value":"valueTrue"},"output":"valueTrue 6 ","children":[]}]}}
var testCase12 = {"testCaseName":"complexMethodCallScenario2","methodExecution":{"methodName":"Object5_method1","input":{"value":"valueFalse"},"output":"valueFalse 1 valueFalse 2 valueFalse 3 valueFalse 5 valueFalse 8 valueFalse 81 valueFalse 811 valueFalse 812 valueFalse 813 valueFalse 82 valueFalse 821 valueFalse 822 valueFalse 823 valueFalse 6 ","children":[{"methodName":"Object5_method2","input":{"value":"valueFalse"},"output":"valueFalse 2 ","children":[]},{"methodName":"Object5_method3","input":{"value":"valueFalse"},"output":"valueFalse 3 ","children":[]},{"methodName":"Object5_method5","input":{"value":"valueFalse"},"output":"valueFalse 5 ","children":[]},{"methodName":"Object5_method8","input":{"value":"valueFalse"},"output":"valueFalse 8 valueFalse 81 valueFalse 811 valueFalse 812 valueFalse 813 valueFalse 82 valueFalse 821 valueFalse 822 valueFalse 823 ","children":[{"methodName":"Object5_method81","input":{"value":"valueFalse"},"output":"valueFalse 81 valueFalse 811 valueFalse 812 valueFalse 813 ","children":[{"methodName":"Object5_method811","input":{"value":"valueFalse"},"output":"valueFalse 811 ","children":[]},{"methodName":"Object5_method812","input":{"value":"valueFalse"},"output":"valueFalse 812 ","children":[]},{"methodName":"Object5_method813","input":{"value":"valueFalse"},"output":"valueFalse 813 ","children":[]}]},{"methodName":"Object5_method82","input":{"value":"valueFalse"},"output":"valueFalse 82 valueFalse 821 valueFalse 822 valueFalse 823 ","children":[{"methodName":"Object5_method821","input":{"value":"valueFalse"},"output":"valueFalse 821 ","children":[]},{"methodName":"Object5_method822","input":{"value":"valueFalse"},"output":"valueFalse 822 ","children":[]},{"methodName":"Object5_method823","input":{"value":"valueFalse"},"output":"valueFalse 823 ","children":[]}]}]},{"methodName":"Object5_method6","input":{"value":"valueFalse"},"output":"valueFalse 6 ","children":[]}]}}
