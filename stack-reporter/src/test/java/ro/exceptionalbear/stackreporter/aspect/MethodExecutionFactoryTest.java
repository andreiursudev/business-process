package ro.exceptionalbear.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.junit.jupiter.api.Test;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecution;
import ro.exceptionalbear.stackreporter.logic.logic1.Object1;
import ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MethodExecutionFactoryTest {
    @Test
    void name() {
        MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        CodeSignature codeSignature = mock(CodeSignature.class);
        when(codeSignature.getParameterNames()).thenReturn(new String[]{"parameterName"});
        when(codeSignature.getDeclaringType()).thenReturn(Object1.class);
        when(codeSignature.getName()).thenReturn("methodName");
        when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"parameterValue"});

        MethodExecution methodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);

        assertEquals(new MethodExecution("ro.rodin.businessprocessesdiagram.logic.logic1", "Object1", "methodName",
                """
                        {
                          "parameterName" : "parameterValue"
                        }"""), methodExecution);
    }
}