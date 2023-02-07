package ro.rodin.businessprocessdemoapp;

public class FormatedSimpleName {
    private String simpleName;

    public FormatedSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String asString() {
        return simpleName.toUpperCase();
    }
}
