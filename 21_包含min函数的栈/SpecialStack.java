import java.util.List;
import java.util.ArrayList;

public class SpecialStack<E extends Comparable> {
    private List<E> elements;
    private List<E> minElements;
    private int size;

    public SpecialStack() {
        elements = new ArrayList<>();
        minElements = new ArrayList<>();
        size = 0;
    }

    public E pop() {
        if (size <= 0)
            throw new RuntimeException("The stack is empty");

        int lastIndex = elements.size() - 1; 
        E ret = elements.remove(lastIndex);
        size--;
        
        if (ret == min()) {
            popMin();
        }
        return ret;
    }

    public void push(E element) {
        elements.add(element);
        size++;
        
        if (minElements.size() == 0 || element.compareTo(min()) <= 0) {
            pushMin(element);
        }
        
    }

    public E min() {
        if (minElements.size() <= 0) 
            throw new RuntimeException("The stack is empty");

        return minElements.get(minElements.size() - 1);
    }

    public int size() {
        return size;
    }

    private E popMin() {
        return minElements.remove(minElements.size() - 1);
    }

    private void pushMin(E element) {
        minElements.add(element);
    }

}