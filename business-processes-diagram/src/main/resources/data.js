var methodsTree =[
    {
        "methodName": "Method1",
    },
    {
        "methodName": "Method2",
        "children" : [{
            "methodName": "Method3",
        }]
    }
    ,
    {
        "methodName": "Method4",
        "children": [{
            "methodName": "Method5",
        },{
            "methodName": "Method6",
        }]
    }
    ,
    {
        "methodName": "Method7",
        "children": [{
            "methodName": "Method8",
        },{
            "methodName": "Method9",
        },
            {
                "methodName": "Method10",
                "children": [{
                    "methodName": "Method11",
                },{
                    "methodName": "Method12",
                }]
            }]
    }
];

let testCasesToMethod = {
    "Method1":
        {
            "testCase1": {
                "Method1": {
                    "input": "myInput1",
                    "output": "myOutput1"
                }
            },
            "testCase2": {
                "Method1": {
                    "input": "myInput2",
                    "output": "myOutput2"
                }
            },
        },
    "Method2":
        {
            "testCase1": {
                "Method2": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method3": {
                    "input": "myInput",
                    "output": "myOutput"
                }
            },
        },
    "Method4":
        {
            "testCase1": {
                "Method4": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method5": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method6": {
                    "input": "myInput",
                    "output": "myOutput"
                }
            }
        },
    "Method7":
        {
            "testCase1": {
                "Method7": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method8": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method9": {
                    "input": "myInput",
                    "output": "myOutput"
                }
            },
            "testCase2": {
                "Method7": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method10": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method11": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method12": {
                    "input": "myInput",
                    "output": "myOutput"
                },
                "Method3": {
                    "input": "myInput",
                    "output": "myOutput"
                },
            }
        }
}