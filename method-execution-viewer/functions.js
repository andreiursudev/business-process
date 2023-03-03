var getKeysByPattern = function (obj, pattern) {
    return Object.keys(obj).filter((key) => pattern.test(key)).reduce((cur, key) => {
        return Object.assign(cur, {[key]: obj[key]})
    }, {});
}

function exists(zNodes, name) {
    return zNodes.some(zNode => zNode['name'] === name);
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
        if(!exists(zNode.children, lastChild.name)){
            zNode.children.push(lastChild);
        }

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

function getPath(methodExecution) {
    return [methodExecution["packageName"],methodExecution["className"],methodExecution["methodName"]].join(".");
}

function getPathAsId(methodExecution){
    return getPath(methodExecution).replaceAll(".","");
}

var getMethodExecution = function(nodePath, methodExecutions){
    let path = nodePath.map(path => path.name).join(".");
    for(var methodExecution of Object.values(methodExecutions)){
        if(path === getPath(methodExecution)){
            return methodExecution;
        }
    }

}
