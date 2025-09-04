package Lab03.pack;

public class MyArray_670050 extends MyArrayBasic {
    public MyArray_670050() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
        size = 0;
    }
    public MyArray_670050(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
        size = 0;
    }

    public boolean isFull() {
        return size>=MAX_SIZE;
    }

    public boolean isEmpty() {
        return size==0;
    }

    private int [] expandByK(int k) {
        MAX_SIZE = MAX_SIZE * k;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data,0,newData,0,size);
        data = newData;
        return newData;
    }

    private int [] expand() {
        return expandByK(2);
    }

    public int binarySearch(int target) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (target < data[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -(left + 1);
    }


    public void insert(int d, int pos) {
        if (size >= MAX_SIZE) expand();

        // ไม่ให้แทรกถ้าทำให้ข้อมูลไม่เรียง
        if (pos > 0 && data[pos - 1] > d) {
            System.out.println("illegal skipped: " + d);
            return;
        }

        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = d;
        size++;
    }


    public void insert(int d) {
        if (size >= MAX_SIZE) expand();

        int pos = binarySearch(d);
        if (pos >= 0) {
            // มีอยู่แล้ว
            System.out.println("duplicate insert skipped: " + d);
            return;
        }
        pos = -(pos + 1); // ตำแหน่งที่จะต้องแทรก

        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = d;
        size++;
    }


    @Override
    public void add(int d) {
        if (size >= MAX_SIZE) {
            expand();
        }
        data[size++] = d;
    }

    @Override
    public void insert_unordered(int pos, int d) {
        if (size >= MAX_SIZE) {
            expand();
        }
        data[size++] = data[pos];
        data[pos] = d;
    }

    @Override
    public void delete(int d) {
        if (isEmpty()) {
            System.out.println("Warning: Attempt to delete from empty array.");
            return;
        }
        for(int i=d; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }
}
