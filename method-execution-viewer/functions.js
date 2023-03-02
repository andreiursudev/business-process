var getKeysByPattern = function (obj, pattern) {
    return Object.keys(obj).filter((key) => pattern.test(key)).reduce((cur, key) => {
        return Object.assign(cur, {[key]: obj[key]})
    }, {});
}

function hasMethodAlreadyBeenAddedToArray(methodsTree, methodName) {
    return methodsTree.some(m => m['methodName'] === methodName);
}

function findExistingMethod(methodsTree, methodName) {
    return methodsTree.find(method => method['methodName'] === methodName);
}

function getUniqueListBy(arr, key) {
    return [...new Map(arr.map(item => [item[key], item])).values()]
}

function flatMethodsToTreeStructure(methods, existingMethods) {
    if (methods.length > 0) {
        for (innerMethod of methods) {
            let innerMethodName = innerMethod["methodName"];
            if (!hasMethodAlreadyBeenAddedToArray(existingMethods, innerMethodName)) {
                existingMethods.push(innerMethod);
            } else {
                let innerExistingMethod = findExistingMethod(existingMethods, innerMethodName);
                flatMethodsToTreeStructure(innerMethod.children, innerExistingMethod.children);
            }
        }
    }
}

var getMethodsTree = function (localTestCases) {
    var methodsTree = [];
    var methods = [];
    for (const [key, testCase] of Object.entries(localTestCases)) {
        methods.push(testCase["methodExecution"])
    }
    flatMethodsToTreeStructure(methods, methodsTree);
    return methodsTree;
}

function getInputOutput(method) {
    return {"input": method["input"], "output": method["output"]};
}

function getInputOutputToMethods(methods) {
    var inputOutputToMethod = {}
    for (method of methods) {
        inputOutputToMethod[method["methodName"]] = getInputOutput(method);
        if (method["children"].length > 0) {
            inputOutputToMethod = {...inputOutputToMethod, ...getInputOutputToMethods(method["children"])};
        }
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

var groupMethodExecutionsByPackageAndClass = function (methodExecutions) {
    var result = {};
    for (var i in methodExecutions) {
        var methodExecution = methodExecutions[i];
        var packageName = methodExecution.packageName;
        var className = methodExecution.className;
        var id = packageName + className;
        if (result[id] == null) {
            result[id] = {
                packageName: methodExecution["packageName"],
                className: methodExecution["className"],
                methodNames: [methodExecution["methodName"]]
            };
        } else {
            result[id].methodNames.push(methodExecution["methodName"]);
        }
    }
    return Object.values(result);
}

function getChildren(methodNames) {
    return methodNames.map(methodName => ({"name": methodName}));
}

function exists(zNodes, directory) {
    return zNodes.some(zNode => zNode['name'] === directory);
}

function getZNode(directories, index, lastChild, zNodes, zNode) {

    if (index < directories.length) {
        let directory = directories[index];
        if(exists(zNodes, directory)){
            let existingZNode = zNodes.find(n => n['name'] === directory);
            getZNode(directories, index+1, lastChild,existingZNode.children, existingZNode)
        } else {
            let zNode = {
                name: directory,
                open: true,
                children: []
            };
            zNodes.push(zNode)
            getZNode(directories, index+1, lastChild,zNode.children, zNode)
        }
    } else {
        zNode.children.push(lastChild);
    }
}

var getZNodes = function (methodExecutions) {
    var result = [];
    for (const [key, methodExecution] of Object.entries(methodExecutions)) {
        var lastChild = {name: methodExecution["methodName"]}

        let directories = methodExecution.packageName.split(".").concat(methodExecution["className"]);

        getZNode(directories, 0, lastChild, result, {});
    }
    return result;
}

/*
var getZNodes = function(methodExecutions) {
    var groupedMethodExecutions = groupMethodExecutionsByPackageAndClass(methodExecutions);

    var zNodes = [];
    for (const [key, methodExecution] of Object.entries(groupedMethodExecutions)) {
        let directories = methodExecution.packageName.split(".");
        var zNode = {
            name: methodExecution["className"],
            open: true,
            children:getChildren(methodExecution["methodNames"])
        };
        for (var i = directories.length - 1; i >= 0; i--) {
            zNode = {
                name: directories[i],
                open: true,
                children:[
                    zNode]
            }
        }
        zNodes.push(zNode);
    }
    return zNodes;
}
*/
