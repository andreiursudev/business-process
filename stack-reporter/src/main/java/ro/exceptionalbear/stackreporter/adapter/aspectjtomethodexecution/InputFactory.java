package ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution;

public class InputFactory {
    static String getInput(String[] parameterNames, Object[] args) {
        if (parameterNames.length == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            result.append(parameterNames[i]).append(" = ").append(args[i]).append("\n");
        }

        return result.toString();
    }
}
