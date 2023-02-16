package ro.rodin.businessprocessesdiagram.logic;

public class Object5 {
    public String method1(String value) {
        String result = value + " 1 ";
        result += method2(value);
        if (value.equals("valueTrue")) {
            result += method3(value);
            result += method4(value);
            result += method7(value);
        } else {
            result += method3(value);
            result += method5(value);
            result += method8(value);
        }
        result += method6(value);
        return result;
    }

    private String method8(String value) {
        return value + " 8 " + method81(value) + method82(value);
    }

    private String method82(String value) {
        return value + " 82 " + method821(value) + method822(value) + method823(value);
    }

    private String method823(String value) {
        return value + " 823 ";
    }

    private String method822(String value) {
        return value + " 822 ";
    }

    private String method821(String value) {
        return value + " 821 ";
    }

    private String method81(String value) {
        return value + " 81 " + method811(value) + method812(value) + method813(value);
    }

    private String method813(String value) {
        return value + " 813 ";
    }

    private String method812(String value) {
        return value + " 812 ";
    }

    private String method811(String value) {
        return value + " 811 ";
    }

    private String method7(String value) {
        return value + " 7 " + method71(value) + method72(value);
    }

    private String method72(String value) {
        String result = value + " 72 ";
        result += method73(value);
        if (value.equals("valueTrue")) {
            result += method74(value);
            result += method75(value);
        } else {
            result += method74(value);
            result += method76(value);
        }
        result += method77(value);
        return result;
    }

    private String method77(String value) {
        return value + " 77 ";
    }

    private String method76(String value) {
        return value + " 76 ";
    }

    private String method75(String value) {
        return value + " 75 ";
    }

    private String method74(String value) {
        return value + " 74 ";
    }

    private String method73(String value) {
        return value + " 73 ";
    }

    private String method71(String value) {
        return value + " 71 ";
    }

    private String method6(String value) {
        return value + " 6 ";
    }

    private String method5(String value) {
        return value + " 5 ";
    }

    private String method4(String value) {
        return value + " 4 ";
    }

    private String method3(String value) {
        return value + " 3 ";
    }

    private String method2(String value) {
        return value + " 2 ";
    }
}
