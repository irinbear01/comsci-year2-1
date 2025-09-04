package Lab06.pack;

import java.util.Iterator;

public class task_2 {
    static void task_2() {
    MyQueueL_670050<String> queue = new MyQueueL_670050<>();
    queue.enqueue("Apple");
    queue.enqueue("Banana");
    queue.enqueue("Cantaloupe");
    System.out.print("standard for each: ");
    for (String item : queue) {
        System.out.print(item + " ");
    }
    System.out.println();
    System.out.println("demo iterator");
    Iterator<String> iter = queue.iterator();
    char ch = 'n';
    while (iter.hasNext()) {
        String item = iter.next();
        if (item.indexOf(ch) != -1) {
            System.out.print(item + " ");
        }
    }
    System.out.println();
    }
}

