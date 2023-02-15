var getKeysByPattern = function (obj, pattern) {
    return Object.keys(obj).filter((key) => pattern.test(key)).reduce((cur, key) => {
        return Object.assign(cur, {[key]: obj[key]})
    }, {});
}

var getMethodsTree = function (testCases) {
    var result = [];
    for (let key in testCases) {
        var testCase = testCases[key];

        var methodExecution = testCase["methodExecution"];
        var methodExecutionName = testCase["methodExecution"]["methodName"];
        if (!result.some(method => method['methodName'] === methodExecutionName)) {
            result.push(methodExecution);
        } else {
            let method = result.find(method => method['methodName'] === methodExecutionName);
            method.children = method.children.concat(methodExecution.children);
        }
    }
    return result;
}

var getTestCasesToMethod = function(myTestCases) {
    var result = {};
    for (let key in myTestCases) {
        var testCase = myTestCases[key];
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