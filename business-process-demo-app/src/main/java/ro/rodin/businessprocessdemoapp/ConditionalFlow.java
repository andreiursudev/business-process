package ro.rodin.businessprocessdemoapp;

public class ConditionalFlow {

    private final IsEmpty isEmpty;

    public ConditionalFlow(IsEmpty isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String process(String firstName, String lastName) {
        if(isEmpty.test(firstName)){
            return firstName;
        } else {
            return lastName;
        }
    }


}
