describe('getKeysByPattern', function() {

    it('should filter keys by pattern', function() {
        let result = getKeysByPattern({firstName: "Andrei", lastName: "Ursu", age : 33}, new RegExp('.*Name.*'));

        expect(result).toEqual({firstName: "Andrei", lastName: "Ursu"});
    });

});

describe('getZNodes', function() {
    it('one methodExecution', function() {
        var methodExecutions = {
            "methodExecution1": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod1",
                "children": []
            }
        }

        let result = getZNodes(methodExecutions);

        expect(result).toEqual([
            {name:"your", open:true, children:[
                    {name:"package", open:true, children:[
                            {name:"name", open:true, children:[
                                    {name:"logic", open:true, children:[
                                            {name:"logic1", open:true, children:[
                                                    {name:"Object1Test", open:true, children:[
                                                            {name:"callMethod1"}]}]}]}]}]}]}]);
    });
})

describe('getZNodes', function() {
    it('two methodExecutions with same package name', function() {
        var methodExecutions = {
            "methodExecution1": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod1",
                "children": []
            },
            "methodExecution2": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod2",
                "children": []
            }
        }

        let result = getZNodes(methodExecutions);

        expect(result).toEqual([
            {name:"your", open:true, children:[
                    {name:"package", open:true, children:[
                            {name:"name", open:true, children:[
                                    {name:"logic", open:true, children:[
                                            {name:"logic1", open:true, children:[
                                                    {name:"Object1Test", open:true, children:[
                                                            {name:"callMethod1"}, {name:"callMethod2"}]}]}]}]}]}]}]);
    });
})

describe('getZNodes', function() {
    it('two methodExecutions with one difference in the package name', function() {
        var methodExecutions = {
            "methodExecution1": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod1",
                "children": []
            },
            "methodExecution2": {
                "packageName": "your.package.name.logic.logic2",
                "className": "Object2Test",
                "methodName": "callMethod2",
                "children": []
            }
        }

        let result = getZNodes(methodExecutions);

        expect(result).toEqual([
            {name:"your", open:true, children:[
                    {name:"package", open:true, children:[
                            {name:"name", open:true, children:[
                                    {name:"logic", open:true, children:[
                                            {name:"logic1", open:true, children:[
                                                    {name:"Object1Test", open:true, children:[
                                                            {name:"callMethod1"}]}]},
                                            {name:"logic2", open:true, children:[
                                                    {name:"Object2Test", open:true, children:[
                                                            {name:"callMethod2"}]}]}]}]}]}]}]);
    });
})

describe('getMethodExecution', function() {
    it('find methodExecution', function() {
        var nodePath = [{name: "your"},{name: "package"},{name: "name"},{name: "logic"},{name: "logic1"},{name: "Object1Test"},{name: "callMethod1"}]

        var methodExecutions = {
            "methodExecution1": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod1",
                "children": []
            },
            "methodExecution2": {
                "packageName": "your.package.name.logic.logic1",
                "className": "Object1Test",
                "methodName": "callMethod2",
                "children": []
            }
        }

        let result = getMethodExecution(nodePath,methodExecutions);

        expect(result).toEqual({
            "packageName": "your.package.name.logic.logic1",
            "className": "Object1Test",
            "methodName": "callMethod1",
            "children": []
        });
    });
})

