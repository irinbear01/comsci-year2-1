public class OSLab7_02 {
    public static void main(String argv[]) {
    Task task = new Task();
    task.start();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException ie) {
    }
        task.interrupt();
    }
}

class Task extends Thread {
    int count = 0;
    public void run() {
        while (true) {
            count += 1;
            System.out.println("I'm doing work#" + count);
            System.out.println("I'm done for work#" + count);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("I'm interrupted !!!");
                return;
            }
        }
    }
}