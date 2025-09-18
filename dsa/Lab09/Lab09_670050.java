package Lab09;

import Lab09.pack.Employee;
import Lab09.pack.MyMinHeap_670050;
import Lab09.pack.MyPriorityQueue_670050;
import java.util.*;

public class Lab09_670050 {
    static ArrayList<Integer> least3;
    public static void main(String[] args) {
        System.out.println("-task1---");
        task_1();
        System.out.println("-task2---");
        task_2();
        System.out.println("-task3---");
        task_3();
        System.out.println("-task4---");
        task_4();
    }    
    static void task_1() {
        least3 = new ArrayList<>();
        MyMinHeap_670050 heap = new MyMinHeap_670050();
        heap.insert(11);
        heap.insert(15);
        heap.insert(16);
        heap.insert(13);
        heap.insert(17);
        heap.insert(18);
        System.out.println("heap structure is " + heap);
        least3.add(heap.remove()); 
        least3.add(heap.remove()); 
        least3.add(heap.remove()); 
        System.out.println("least 3 value is " + least3);
    } 
    static void task_2() {
        least3 = new ArrayList<>();
        MyPriorityQueue_670050 pq = new MyPriorityQueue_670050();
        pq.enqueue(11);
        pq.enqueue(15);
        pq.enqueue(16);
        pq.enqueue(13);
        pq.enqueue(17);
        pq.enqueue(18);
        pq.enqueue(19); // isFull() is true ...discard
        System.out.println("pq structure is " + pq);
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        System.out.println("least 3 value is " + least3);
    }
    static void task_3() {
        PriorityQueue<Employee> pq = new PriorityQueue<>(
                                            (e1,e2) -> Integer.compare(e1.getSalary(),e2.getSalary()));
        List<Employee> list = Arrays.asList(new Employee("Yindee", 2000),
                                            new Employee("Preeda", 1500),
                                            new Employee("Pramote", 3000));
        pq.addAll(list);
        System.out.println(pq);
        // [Emp Preeda(1500), Emp Yindee(2000), Emp Pramote(3000)]
    }
    static void task_4() {
        int lastStoneWeight = 0;
        int[] stones = {2,7,4,1,8,1};
            
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // เติมหินทั้งหมดลง heap
        for (int s : stones) {
            maxHeap.offer(s);
        }

        //ทุบหินทีละคู่
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // ก้อนหนักสุด
            int stone2 = maxHeap.poll(); // ก้อนรองลงมา

            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2); // ถ้ายังเหลือเศษ ให้ใส่กลับ
            }
        }

        // ถ้า heap ว่าง เหลือ 0, ถ้ามี คือก้อนสุดท้าย
        lastStoneWeight = maxHeap.isEmpty() ? 0 : maxHeap.peek();
        System.out.println(lastStoneWeight);
    }
}
