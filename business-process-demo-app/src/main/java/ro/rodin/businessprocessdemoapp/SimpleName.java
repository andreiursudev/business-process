package ro.rodin.businessprocessdemoapp;

public class SimpleName {
    private Name name;

    public SimpleName(Name name) {
        this.name = name;
    }


    public String asString(){
        return name.getFirstName() + " " + name.getLastName();
    }

}
