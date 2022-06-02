import java.util.ArrayList;

public class Array {
    public ArrayList<Object> elements;

    public Array(ArrayList<Object> newElements) {
        this.elements = new ArrayList<>();
        for(Object newElement : newElements)
            this.elements.add(getNewObject(newElement));
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

    public int getSize() {return this.elements.size();}

    public void addElement(Object o) {this.elements.add(getNewObject(o));}

    public void print() {
        for (Object element : elements) {
            System.out.
        }
    }

}