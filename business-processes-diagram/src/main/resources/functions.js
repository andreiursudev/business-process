var getKeysByPattern = function (obj, pattern) {
    return Object.keys(obj).filter((key) => pattern.test(key)).reduce((cur, key) => {
        return Object.assign(cur, {[key]: obj[key]})
    }, {});
}

function hasMethodAlreadyBeenAddedToTree(methodsTree, methodName) {
    return methodsTree.some(m => m['methodName'] === methodName);
}

function findExistingMethod(methodsTree, methodName) {
    return methodsTree.find(method => method['methodName'] === methodName);
}

function getUniqueListBy(arr, key) {
    return [...new Map(arr.map(item => [item[key], item])).values()]
}

var getMethodsTree = function (localTestCases) {
    var methodsTree = [];
    for (const [key, testCase] of Object.entries(localTestCases)) {
        var method = testCase["methodExecution"];
        var methodName = method["methodName"];
        if (!hasMethodAlreadyBeenAddedToTree(methodsTree, methodName)) {
            methodsTree.push(method);
        } else {
            let existingMethod = findExistingMethod(methodsTree, methodName);
            existingMethod.children = getUniqueListBy(existingMethod.children.concat(method.children),"methodName");
        }
    }
    return methodsTree;
}

function getInputOutput(method) {
    return {"input": method["input"], "output": method["output"]};
}

function getInputOutputToMethods(methods) {
    var inputOutputToMethod = {}
    for (method of methods) {
        inputOutputToMethod[method["methodName"]] = getInputOutput(method);
    }
    return inputOutputToMethod;
}

function getInputOutputToMethodsIncludingChildren(method) {
    return {...{[method["methodName"]]: getInputOutput(method)}, ...getInputOutputToMethods(method["children"])};
}

function doesMethodAlreadyHasATestCase(testCasesToMethod, methodName) {
    return testCasesToMethod.hasOwnProperty(methodName);
}

function getAlreadyExistingTestCasesOrNewForMethodName(testCasesToMethod, methodName) {
    let testCases = {};
    if (doesMethodAlreadyHasATestCase(testCasesToMethod, methodName)) {
        testCases = testCasesToMethod[methodName];
    }
    return testCases;
}

var getTestCasesToMethod = function (localTestCases) {
    var testCasesToMethod = {};

    for (const [key, testCase] of Object.entries(localTestCases)) {
        let method = testCase["methodExecution"];
        var methodName = method["methodName"];
        var testCaseName = testCase["testCaseName"];

        let testCases = getAlreadyExistingTestCasesOrNewForMethodName(testCasesToMethod, methodName);

        testCases[testCaseName] = getInputOutputToMethodsIncludingChildren(method);
        testCasesToMethod[methodName] = testCases;
    }
    return testCasesToMethod;
}