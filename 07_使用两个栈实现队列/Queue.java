import java.util.ArrayList;
import java.util.List;

public class Queue<E> {
    private final List<E> addStack;
    private final List<E> deleteStack;

    private int size;

    public Queue() {
        addStack = new ArrayList<>();
        deleteStack = new ArrayList<>();
    }

    public void appendTail(E val) {
        addStack.add(val);
        size++;
    }

    public E deleteHead() {
        if (size == 0)
            throw new RuntimeException("queue is empty");
        if (deleteStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                deleteStack.add(addStack.remove(addStack.size() - 1));
            }
        }
        size--;
        return deleteStack.remove(deleteStack.size() - 1);
    }

    public int size() {
        return size;
    }

}