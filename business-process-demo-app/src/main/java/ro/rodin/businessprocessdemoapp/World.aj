package ro.rodin.businessprocessdemoapp;

public aspect World {
    pointcut wrapAll() : execution(* ro.rodin.businessprocessdemoapp.NameToJson.toJson(..));
    //pointcut wrapAll() : execution(* *(..));

    before() : wrapAll(){
        System.out.println("args=" + thisJoinPoint.getArgs());
        System.out.println("target=" + thisJoinPoint.getTarget().getClass().getSimpleName());
        System.out.println("target=" + thisJoinPoint.getTarget().getClass().getPackageName());
    }

    after() returning(Object o) : wrapAll(){
        System.out.println("return =" + o);
    }
}