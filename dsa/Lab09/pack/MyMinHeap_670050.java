package Lab09.pack;

public class MyMinHeap_670050 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;
    
    private void swap(int i, int j) {
        heap[i] = heap[i] + heap[j];
        heap[j] = heap[i] - heap[j];
        heap[i] = heap[i] - heap[j];
    }
    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int parent = (p-1)/2;
        while((p>0) && (heap[p]<heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p-1)/2;
        }
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d;
        int p = 0;
        while (true) {
            int left = 2*p+1;
            if(left>=size) break; // no child
            int right = 2*p+2;
            if(right==size) { // one child
            if(heap[p]>heap[left])
                swap(p,left);
                break; // no more child,
                        // nothing to do
            } else { // two childs
                int q = heap[left]<heap[right]?left:right;
                if(heap[p]>heap[q]) swap(p,q);
                else break;
                p = q;
            }
            System.out.println("heap snapshot (cur_size = " + size + ") " + this.toString());
        } 
        return d;
    } //end while

    public String toString() {
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < size; i++) {
            sb.append(heap[i]);
            sb.append(",");
        }
        if (size > 0) {
            sb.append("]");
        }
        return sb.toString();
    }
    
}
