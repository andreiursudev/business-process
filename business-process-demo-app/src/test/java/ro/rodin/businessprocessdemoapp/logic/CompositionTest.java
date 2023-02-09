package ro.rodin.businessprocessdemoapp.logic;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositionTest {

   /* @Test
    void name() {
        Layer1 layer1 = new Layer1(new Layer2());

        layer1.doSomething();

        assertEquals(List.of(new Element(new LinkedHashMap<>(),
                                "ro.rodin.businessprocessdemoapp.logic",
                                "Layer1",
                                "doSomething",
                                null),
                        new Element(new LinkedHashMap<>(),
                                "ro.rodin.businessprocessdemoapp.logic",
                                "Layer2",
                                "doSomethingElse",
                                null)),
                Diagram.getElements());
    }*/

    @Test
    void name() {
        SortedSet<Integer> tree=new TreeSet<>();

        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);



        System.out.println(tree);
    }
}
