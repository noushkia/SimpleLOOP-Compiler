package main.visitor.codeGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Array {
    public ArrayList<Object> elements;

    public Array(ArrayList<Object> newElements) {
        this.elements = new ArrayList<>();
        for(Object newElement : newElements)
            this.elements.add(getNewObject(newElement));
    }

    public Array(int leftVal, int rightVal) {
        this.elements = new ArrayList<>(List.of(IntStream.rangeClosed(leftVal, rightVal).toArray()));
    }

    public Array(Array that) {
        this(that.elements);
    }

    private Object getNewObject(Object o) {
        if(o instanceof Array)
            return new Array((Array) o);
        else
            return o;
    }

    public Object getElement(int index) {
        return this.elements.get(index);
    }

    public void setElements(int index, Object value) {
        this.elements.set(index, value);
    }

    public int getSize() {return this.elements.size();}

    public void addElement(Object o) {this.elements.add(getNewObject(o));}

    public ArrayList<Object> getElements() {
        return this.elements;
    }

}
