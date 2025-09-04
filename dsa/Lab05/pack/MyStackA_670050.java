package pack;

import java.util.ArrayList;

public class MyStackA_670050<T> {   // extends ArrayList<T> {
                            // extends would expose MyStack object for calling any of the ArrayList's methods
    private ArrayList<T> items = new ArrayList<>();

    public void push(T d) {
        items.add(d);
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Empty");
        return items.remove(items.size()-1);
    }

    public T peek() {
        return items.get(items.size()-1);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size() - 1; i > 0; i--)
            sb.append(items.get(i) + ", "); 
        if (items.size() > 0)
            sb.append(items.get(0));
        sb.append("]");
        return sb.toString();
    }
}
