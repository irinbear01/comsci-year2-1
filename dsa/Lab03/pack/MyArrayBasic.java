package Lab03.pack;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic (int ... a) {
        MAX_SIZE = a.length;
        data = new int[MAX_SIZE];
        for (int i = 0; i < a.length; i++) {
            data[i] = a[i];
        }
        size = a.length;
    }

    public MyArrayBasic() {
        data = new int[MAX_SIZE]; 
    }

    public void add(int d) {
    if (size >= MAX_SIZE) {
        throw new ArrayIndexOutOfBoundsException("Array is full");
    }
    data[size++] = d;
    }

    public void insert_unordered(int idx, int d) {
        if (size >= MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Array is full");
        }
        data[size++] = data[idx];
        data[idx] = d;
    }

    public int find(int d) {
        for(int i = 0; i<size; i++) {
            if(data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    void delete(int index) {
        for(int i=index; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public int getAt(int index) {
        return data[index];
    }

    public void setAt(int index) {
        data[index] = data[index];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<size-1; i++) {
            sb.append(data[i]);
            sb.append(",");
        }
        if (size>0) sb.append(data[size-1]);
        sb.append("]");
        return sb.toString();
    }
}
