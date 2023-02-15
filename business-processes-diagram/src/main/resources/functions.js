var getKeysByPattern = function (obj, pattern) {
    return Object.keys(obj).filter((key) => pattern.test(key)).reduce((cur, key) => {
        return Object.assign(cur, {[key]: obj[key]})
    }, {});
}

var getMethodsTree = function (localTestCases) {
    var methodsTree = [];
    for (let key in localTestCases) {
        var testCase = localTestCases[key];

        var methodExecution = testCase["methodExecution"];
        var methodExecutionName = testCase["methodExecution"]["methodName"];
        if (!methodsTree.some(method => method['methodName'] === methodExecutionName)) {
            methodsTree.push(methodExecution);
        } else {
            let method = methodsTree.find(method => method['methodName'] === methodExecutionName);
            method.children = method.children.concat(methodExecution.children);
        }
    }
    return methodsTree;
}

var getTestCasesToMethod = function(localTestCases) {
    var result = {};
    for (let key in localTestCases) {
        var testCase = localTestCases[key];
        var executedMethodName = testCase["methodExecution"]["methodName"];
        var testCaseName = testCase["testCaseName"];
        var executedMethodInput = testCase["methodExecution"]["input"];
        var executedMethodOutput = testCase["methodExecution"]["output"];

        let methods = {};
        methods[executedMethodName] = {"input": executedMethodInput, "output": executedMethodOutput};
        let testCases = {};
        if(result.hasOwnProperty(executedMethodName)){
            testCases = result[executedMethodName];
        }

        var methodExecutionChildren = testCase["methodExecution"]["children"];
        for (child of methodExecutionChildren) {
            methods[child["methodName"]] = {"input": child["input"], "output": child["output"]};
        }

        testCases[testCaseName] = methods;
        result[executedMethodName] = testCases;
    }
    return result;
}