describe('getKeysByPattern', function() {

    it('should filter keys by pattern', function() {
        let result = getKeysByPattern({firstName: "Andrei", lastName: "Ursu", age : 33}, new RegExp('.*Name.*'));

        expect(result).toEqual({firstName: "Andrei", lastName: "Ursu"});
    });

});

describe('getMethodsTree', function() {
    it('callMethod1', function() {
        var testCases = {testCase1: {"testCaseName":"callMethod1","methodExecution":{"methodName":"method1","children":[]}}}

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'method1', children: [  ] }]);
    });

    it('callMethod2 two scenarios', function() {
        var testCases = {
            testCase2 : {"testCaseName":"callMethod2Scenario1","methodExecution":{"methodName":"method2","children":[]}},
            testCase3 : {"testCaseName":"callMethod2Scenario2","methodExecution":{"methodName":"method2","children":[]}}
        }

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'method2', children: [  ] }]);
    });

    it('methodCallsAnotherMethod one scenario', function() {
        var testCases = {
            testCase4 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","children":[{"methodName":"Object2_method2","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object2_method1', children: [{"methodName":"Object2_method2", "children":[]}  ] }]);
    });

    it('methodCallsAnotherMethod two scenarios', function() {
        var testCases = {
            testCase4 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","children":[{"methodName":"Object2_method2","children":[]}]}},
            testCase5 : {"testCaseName":"methodCallsAnotherMethodScenario2","methodExecution":{"methodName":"Object2_method1","children":[{"methodName":"Object2_method2","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object2_method1', children: [{"methodName":"Object2_method2", "children":[]}  ] }]);
    });

    it('methodCallsTwoOtherMethods one scenario', function() {
        var testCases = {
            testCase6 : {"testCaseName":"methodCallsTwoOtherMethodsScenario1","methodExecution":{"methodName":"Object2_method3","children":[{"methodName":"Object2_method4","children":[]},{"methodName":"Object2_method5","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object2_method3', children: [{"methodName":"Object2_method4", "children":[]}, {"methodName":"Object2_method5","children":[]} ] }]);
    });

    it('methodCallsTwoOtherMethods two scenarios', function() {
        var testCases = {
            testCase6 : {"testCaseName":"methodCallsTwoOtherMethodsScenario1","methodExecution":{"methodName":"Object2_method3","children":[{"methodName":"Object2_method4","children":[]},{"methodName":"Object2_method5","children":[]}]}},
            testCase7 : {"testCaseName":"methodCallsTwoOtherMethodsScenario2","methodExecution":{"methodName":"Object2_method3","children":[{"methodName":"Object2_method4","children":[]},{"methodName":"Object2_method5","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object2_method3', children: [{"methodName":"Object2_method4", "children":[]}, {"methodName":"Object2_method5","children":[]} ] }]);
    });

    it('conditionalMethodCallTrue', function() {
        var testCases = {
            testCase8 : {"testCaseName":"conditionalMethodCallTrue","methodExecution":{"methodName":"Object3_method1","children":[{"methodName":"Object3_method2","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object3_method1', children: [{"methodName":"Object3_method2", "children":[]} ] }]);
    });

    it('conditionalMethodCallTrueAndFalse', function() {
        var testCases = {
            testCase8 : {"testCaseName":"conditionalMethodCallTrue","methodExecution":{"methodName":"Object3_method1","children":[{"methodName":"Object3_method2","children":[]}]}},
            testCase9 : {"testCaseName":"conditionalMethodCallFalse","methodExecution":{"methodName":"Object3_method1","children":[{"methodName":"Object3_method3","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object3_method1', children: [{"methodName":"Object3_method2", "children":[]}, {"methodName":"Object3_method3", "children":[]}   ] }]);
    });

    it('methodCallsInnerMethod', function() {
        var testCases = {
            testCase10 : {"testCaseName":"methodCallsInnerMethod","methodExecution":{"methodName":"Object4_method1","children":[{"methodName":"Object4_method2","children":[{"methodName":"Object4_method3","children":[]}]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object4_method1', children: [{"methodName":"Object4_method2", children:[{"methodName":"Object4_method3","children":[]}]}  ] }]);
    });

    it('methodCallsInnerConditionMethod', function() {
        var testCases = {
            testCase11 : {"testCaseName":"methodCallsInnerConditionMethodScenario1","methodExecution":{"methodName":"Object5_method1","children":[{"methodName":"Object5_method2","children":[{"methodName":"Object5_method3","children":[]}]}]}},
            testCase12 : {"testCaseName":"methodCallsInnerConditionMethodScenario2","methodExecution":{"methodName":"Object5_method1","children":[{"methodName":"Object5_method2","children":[{"methodName":"Object5_method4","children":[]}]}]}},
            testCase13 : {"testCaseName":"methodCallsInnerConditionMethodScenario3","methodExecution":{"methodName":"Object5_method1","children":[{"methodName":"Object5_method5","children":[{"methodName":"Object5_method6","children":[]}]}]}},
            testCase14 : {"testCaseName":"methodCallsInnerConditionMethodScenario4","methodExecution":{"methodName":"Object5_method1","children":[{"methodName":"Object5_method5","children":[{"methodName":"Object5_method7","children":[]}]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{
            methodName: 'Object5_method1',
            children: [{"methodName": "Object5_method2", children: [{"methodName": "Object5_method3", "children": []}, {"methodName": "Object5_method4", "children": []}]
                    }, {"methodName": "Object5_method5", children: [{"methodName": "Object5_method6", "children": []}, {"methodName": "Object5_method7", "children": []}]}]
        }]);
    });

    it('methodCallsTwiceInnerConditionMethod', function() {
        var testCases = {
            testCase15: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario1","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method11","children":[{"methodName":"Object6_method111","children":[{"methodName":"Object6_method1111","children":[]}]}]}]}},
            testCase16: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario2","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method11","children":[{"methodName":"Object6_method111","children":[{"methodName":"Object6_method1112","children":[]}]}]}]}},
            testCase17: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario3","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method11","children":[{"methodName":"Object6_method112","children":[{"methodName":"Object6_method1121","children":[]}]}]}]}},
            testCase18: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario4","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method11","children":[{"methodName":"Object6_method112","children":[{"methodName":"Object6_method1122","children":[]}]}]}]}},
            testCase19: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario5","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method12","children":[{"methodName":"Object6_method121","children":[{"methodName":"Object6_method1211","children":[]}]}]}]}},
            testCase20: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario6","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method12","children":[{"methodName":"Object6_method121","children":[{"methodName":"Object6_method1212","children":[]}]}]}]}},
            testCase21: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario7","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method12","children":[{"methodName":"Object6_method122","children":[{"methodName":"Object6_method1221","children":[]}]}]}]}},
            testCase22: {"testCaseName":"methodCallsTwiceInnerConditionMethodScenario8","methodExecution":{"methodName":"Object6_method1","children":[{"methodName":"Object6_method12","children":[{"methodName":"Object6_method122","children":[{"methodName":"Object6_method1222","children":[]}]}]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{
            methodName: 'Object6_method1',
            children: [{"methodName": "Object6_method11",
                children: [{"methodName": "Object6_method111",
                    children: [{"methodName": "Object6_method1111", "children": []}, {"methodName": "Object6_method1112", "children": []}]},
                           {"methodName": "Object6_method112",
                    children: [{"methodName": "Object6_method1121", "children": []}, {"methodName": "Object6_method1122", "children": []}]}]},
                        {"methodName": "Object6_method12",
                children: [{"methodName": "Object6_method121",
                    children: [{"methodName": "Object6_method1211", "children": []}, {"methodName": "Object6_method1212", "children": []}]},
                           {"methodName": "Object6_method122",
                        children: [{"methodName": "Object6_method1221", "children": []}, {"methodName": "Object6_method1222", "children": []}]}]}]
        }]);
    });

})

describe('getTestCasesToMethod', function() {
    it('callMethod1', function() {
        var testCases = {testCase1: {"testCaseName":"callMethod1","methodExecution":{"methodName":"method1","input":{"value":"value"},"output":"result value","children":[]}}}

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"method1":{"callMethod1": {"method1": {"input": {"value":"value"},"output": "result value"}}}});
    });

    it('callMethod2 two Scenarios', function() {
        var testCases = {
            testCase2 : {"testCaseName":"callMethod2Scenario1","methodExecution":{"methodName":"method2","input":{"value":"value1"},"output":"result value1","children":[]}},
            testCase3 : {"testCaseName":"callMethod2Scenario2","methodExecution":{"methodName":"method2","input":{"value":"value2"},"output":"result value2","children":[]}}
        }

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"method2":{
            "callMethod2Scenario1": {"method2": {"input": {"value":"value1"},"output": "result value1"}},
            "callMethod2Scenario2": {"method2": {"input": {"value":"value2"},"output": "result value2"}}}});
    });

    it('methodCallsAnotherMethod one scenario', function() {
        var testCases = {
            testCase4 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","input":{"value":"value1"},"output":"value1 1 2","children":[{"methodName":"Object2_method2","input":{"value":"value1 1"},"output":"value1 1 2","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object2_method1":{
                "methodCallsAnotherMethodScenario1": {
                    "Object2_method1": {"input": {"value":"value1"},"output": "value1 1 2"},
                    "Object2_method2": {"input": {"value":"value1 1"},"output": "value1 1 2"}}}

        }
        );
    });

    it('methodCallsAnotherMethod two scenarios', function() {
        var testCases = {
            testCase4 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","input":{"value":"value1"},"output":"1 2 value1","children":[{"methodName":"Object2_method2","input":{"value":"value1"},"output":"2 value1","children":[]}]}},
            testCase5 : {"testCaseName":"methodCallsAnotherMethodScenario2","methodExecution":{"methodName":"Object2_method1","input":{"value":"value2"},"output":"1 2 value2","children":[{"methodName":"Object2_method2","input":{"value":"value2"},"output":"2 value2","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object2_method1":{
                    "methodCallsAnotherMethodScenario1": {
                        "Object2_method1": {"input": {"value":"value1"},"output": "1 2 value1"},
                        "Object2_method2": {"input": {"value":"value1"},"output": "2 value1"}},
                "methodCallsAnotherMethodScenario2": {
                    "Object2_method1": {"input": {"value":"value2"},"output": "1 2 value2"},
                    "Object2_method2": {"input": {"value":"value2"},"output": "2 value2"}}}

            }
        );
    });

    it('methodCallsTwoOtherMethods one scenario', function() {
        var testCases = {
            testCase6 : {"testCaseName":"methodCallsTwoOtherMethodsScenario1","methodExecution":{"methodName":"Object2_method3","input":{"value":"value"},"output":"3 4 value 5 value","children":[{"methodName":"Object2_method4","input":{"value":"value"},"output":"4 value","children":[]},{"methodName":"Object2_method5","input":{"value":"value"},"output":"5 value","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object2_method3": {
                "methodCallsTwoOtherMethodsScenario1": {
                    "Object2_method3": {"input": {"value": "value"}, "output": "3 4 value 5 value"},
                    "Object2_method4": {"input": {"value": "value"}, "output": "4 value"},
                    "Object2_method5": {"input": {"value": "value"}, "output": "5 value"}
                }
            }
        });
    });

    it('methodCallsTwoOtherMethods two scenarios', function() {
        var testCases = {
            testCase6 : {"testCaseName":"methodCallsTwoOtherMethodsScenario1","methodExecution":{"methodName":"Object2_method3","input":{"value":"value1"},"output":"value1 3 value1 4 value1 5 ","children":[{"methodName":"Object2_method4","input":{"value":"value1"},"output":"value1 4 ","children":[]},{"methodName":"Object2_method5","input":{"value":"value1"},"output":"value1 5 ","children":[]}]}},
            testCase7 : {"testCaseName":"methodCallsTwoOtherMethodsScenario2","methodExecution":{"methodName":"Object2_method3","input":{"value":"value2"},"output":"value2 3 value2 4 value2 5 ","children":[{"methodName":"Object2_method4","input":{"value":"value2"},"output":"value2 4 ","children":[]},{"methodName":"Object2_method5","input":{"value":"value2"},"output":"value2 5 ","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object2_method3": {
                "methodCallsTwoOtherMethodsScenario1": {
                    "Object2_method3": {"input": {"value": "value1"}, "output": "value1 3 value1 4 value1 5 "},
                    "Object2_method4": {"input": {"value": "value1"}, "output": "value1 4 "},
                    "Object2_method5": {"input": {"value": "value1"}, "output": "value1 5 "}
                },
                "methodCallsTwoOtherMethodsScenario2": {
                    "Object2_method3": {"input": {"value": "value2"}, "output": "value2 3 value2 4 value2 5 "},
                    "Object2_method4": {"input": {"value": "value2"}, "output": "value2 4 "},
                    "Object2_method5": {"input": {"value": "value2"}, "output": "value2 5 "}
                }
            }
        });
    });

    it('conditionalMethodCallTrue', function() {
        var testCases = {
            testCase8 : {"testCaseName":"conditionalMethodCallTrue","methodExecution":{"methodName":"Object3_method1","input":{"value":"valueTrue"},"output":"valueTrue 1 valueTrue 2 ","children":[{"methodName":"Object3_method2","input":{"value":"valueTrue"},"output":"valueTrue 2 ","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object3_method1": {
                "conditionalMethodCallTrue": {
                    "Object3_method1": {"input": {"value": "valueTrue"}, "output": "valueTrue 1 valueTrue 2 "},
                    "Object3_method2": {"input": {"value": "valueTrue"}, "output": "valueTrue 2 "}
                }}});
    });

    it('conditionalMethodCallTrueAndFalse', function() {
        var testCases = {
            testCase8: {"testCaseName":"conditionalMethodCallTrue","methodExecution":{"methodName":"Object3_method1","input":{"value":"valueTrue"},"output":"valueTrue 1 valueTrue 2 ","children":[{"methodName":"Object3_method2","input":{"value":"valueTrue"},"output":"valueTrue 2 ","children":[]}]}},
            testCase9: {"testCaseName":"conditionalMethodCallFalse","methodExecution":{"methodName":"Object3_method1","input":{"value":"valueFalse"},"output":"valueFalse 1 valueFalse 3 ","children":[{"methodName":"Object3_method3","input":{"value":"valueFalse"},"output":"valueFalse 3 ","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object3_method1":{
                    "conditionalMethodCallTrue": {
                        "Object3_method1": {"input": {"value":"valueTrue"},"output": "valueTrue 1 valueTrue 2 "},
                        "Object3_method2": {"input": {"value":"valueTrue"},"output": "valueTrue 2 "}
                    },
                    "conditionalMethodCallFalse": {
                        "Object3_method1": {"input": {"value":"valueFalse"},"output": "valueFalse 1 valueFalse 3 "},
                        "Object3_method3": {"input": {"value":"valueFalse"},"output": "valueFalse 3 "}
                    }
            }}
        );
    });

    it('methodCallsInnerMethod', function() {
        var testCases = {
            testCase10 : {"testCaseName":"methodCallsInnerMethod","methodExecution":{"methodName":"Object4_method1","input":{"value":"value1"},"output":"value1 1 value1 2 value1 3 ","children":[{"methodName":"Object4_method2","input":{"value":"value1"},"output":"value1 2 value1 3 ","children":[{"methodName":"Object4_method3","input":{"value":"value1"},"output":"value1 3 ","children":[]}]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object4_method1":{
                "methodCallsInnerMethod": {
                    "Object4_method1": {"input": {"value":"value1"},"output": "value1 1 value1 2 value1 3 "},
                    "Object4_method2": {"input": {"value":"value1"},"output": "value1 2 value1 3 "},
                    "Object4_method3": {"input": {"value":"value1"},"output": "value1 3 "}
                }
            }});
    });
})

