package ro.rodin.businessprocessdemoapp.diagram;

public enum GlobalDiagram {

    INSTANCE(new Diagram());

    private final Diagram diagram;

    GlobalDiagram(Diagram diagram){
        this.diagram = diagram;
    }

    public static Diagram getDiagram(){
        return INSTANCE.diagram;
    }
}
