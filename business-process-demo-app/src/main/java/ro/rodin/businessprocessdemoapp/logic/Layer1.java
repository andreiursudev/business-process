package ro.rodin.businessprocessdemoapp.logic;

public class Layer1 {
    private Layer2 layer2;

    public Layer1(Layer2 layer2) {
        this.layer2 = layer2;
    }

    public void doSomething() {
        System.out.println("Layer1 doSomething");
        layer2.doSomethingElse();
    }
}
