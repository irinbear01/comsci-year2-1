package Lab09.pack;

public class MyPriorityQueue_670050 implements MyQueueIntf {
    MyMinHeap_670050 heap = new MyMinHeap_670050();
    
    @Override
    public void enqueue(int d) {
        heap.insert(d);
    }

    @Override
    public int dequeue() {
        return heap.remove();
    }

    @Override
    public int front() {
        return heap.peek();
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }    

    @Override
    public String toString() {
        return heap.toString();
    }
}
