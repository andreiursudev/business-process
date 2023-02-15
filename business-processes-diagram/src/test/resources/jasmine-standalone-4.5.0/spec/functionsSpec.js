describe('getKeysByPattern', function() {

    it('should filter keys by pattern', function() {
        let result = getKeysByPattern({firstName: "Andrei", lastName: "Ursu", age : 33}, new RegExp('.*Name.*'));

        expect(result).toEqual({firstName: "Andrei", lastName: "Ursu"});
    });

});

describe('getMethodsTree', function() {
    it('should return one method', function() {
        var testCases = {testCase0: {"testCaseName":"callMethod1","methodExecution":{"methodName":"method1","children":[]}}}

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'method1', children: [  ] }]);
    });

    it('should return one method given two test cases', function() {
        var testCases = {
            testCase1 : {"testCaseName":"callMethod2Scenario1","methodExecution":{"methodName":"method2","children":[]}},
            testCase2 : {"testCaseName":"callMethod2Scenario2","methodExecution":{"methodName":"method2","children":[]}}
        }

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'method2', children: [  ] }]);
    });

    it('should return two method given two method calls', function() {
        var testCases = {
            testCase3 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","children":[{"methodName":"Object2_method2","children":[]}]}}
        };

        let result = getMethodsTree(testCases);

        expect(result).toEqual([{ methodName: 'Object2_method1', children: [{"methodName":"Object2_method2", "children":[]}  ] }]);
    });

})

describe('getTestCasesToMethod', function() {
    it('should return one test case', function() {
        var testCases = {testCase0: {"testCaseName":"callMethod1","methodExecution":{"methodName":"method1","input":{"value":"value"},"output":"result value","children":[]}}}


        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"method1":{"callMethod1": {"method1": {"input": {"value":"value"},"output": "result value"}}}});
    });

    it('should return two test cases for one method', function() {
        var testCases = {
            testCase1 : {"testCaseName":"callMethod2Scenario1","methodExecution":{"methodName":"method2","input":{"value":"value1"},"output":"result value1","children":[]}},
            testCase2 : {"testCaseName":"callMethod2Scenario2","methodExecution":{"methodName":"method2","input":{"value":"value2"},"output":"result value2","children":[]}}
        }

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"method2":{
            "callMethod2Scenario1": {"method2": {"input": {"value":"value1"},"output": "result value1"}},
            "callMethod2Scenario2": {"method2": {"input": {"value":"value2"},"output": "result value2"}}}});
    });

    it('should return two method given two method calls', function() {
        var testCases = {
            testCase3 : {"testCaseName":"methodCallsAnotherMethodScenario1","methodExecution":{"methodName":"Object2_method1","input":{"value":"value1"},"output":"value1 1 2","children":[{"methodName":"Object2_method2","input":{"value":"value1 1"},"output":"value1 1 2","children":[]}]}}
        };

        let result = getTestCasesToMethod(testCases);

        expect(result).toEqual({"Object2_method1":{
                "methodCallsAnotherMethodScenario1": {
                    "Object2_method1": {"input": {"value":"value1"},"output": "value1 1 2"},
                    "Object2_method2": {"input": {"value":"value1 1"},"output": "value1 1 2"}}}

        }
        );
    });
})

