var testCase0 = {
    "testCaseName": "callMethod1",
    "methodExecution": {
        "methodName": "Object1_method1",
        "input": {"value": "value"},
        "output": "result value",
        "children": []
    }
};
var testCase1 = {
    "testCaseName": "callMethod2Scenario1",
    "methodExecution": {
        "methodName": "Object1_method2",
        "input": {"value": "value1"},
        "output": "result value1",
        "children": []
    }
};
var testCase2 = {
    "testCaseName": "callMethod2Scenario2",
    "methodExecution": {
        "methodName": "Object1_method2",
        "input": {"value": "value2"},
        "output": "result value2",
        "children": []
    }
};
var testCase3 = {
    "testCaseName": "methodCallsAnotherMethodScenario1",
    "methodExecution": {
        "methodName": "Object2_method1",
        "input": {"value": "value1"},
        "output": "1 2 value1",
        "children": [{
            "methodName": "Object2_method2",
            "input": {"value": "value1"},
            "output": "2 value1",
            "children": []
        }]
    }
};
var testCase4 = {
    "testCaseName": "methodCallsAnotherMethodScenario2",
    "methodExecution": {
        "methodName": "Object2_method1",
        "input": {"value": "value2"},
        "output": "1 2 value2",
        "children": [{
            "methodName": "Object2_method2",
            "input": {"value": "value2"},
            "output": "2 value2",
            "children": []
        }]
    }
};
var testCase5 = {
    "testCaseName": "methodCallsTwoOtherMethods",
    "methodExecution": {
        "methodName": "Object2_method3",
        "input": {"value": "value"},
        "output": "3 4 value 5 value",
        "children": [{
            "methodName": "Object2_method4",
            "input": {"value": "value"},
            "output": "4 value",
            "children": []
        }, {"methodName": "Object2_method5", "input": {"value": "value"}, "output": "5 value", "children": []}]
    }
};
var testCase6 = {
    "testCaseName": "conditionalMethodCallTrue",
    "methodExecution": {
        "methodName": "Object3_method1",
        "input": {"value": "valueTrue"},
        "output": "2 valueTrue",
        "children": []
    }
};
var testCase7 = {
    "testCaseName": "conditionalMethodCallFalse1111111111111111",
    "methodExecution": {
        "methodName": "Object3_method1",
        "input": {"value": "valueFalse"},
        "output": "3 valueFalse",
        "children": [{
            "methodName": "Object3_method333333",
            "input": {"value": "valueFalse"},
            "output": "3 valueFalse",
            "children": []
        }]
    }
};
