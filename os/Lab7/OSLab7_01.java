class Worker1 extends Thread {
    public void run() {
        System.out.println("I'm a worker1");
}
}
class Worker2 extends Thread {
    public void run() {
        System.out.println("I'm a worker2");
    }
}

public class OSLab7_01 {
public static void main(String [] args) {
    Worker1 wk1 = new Worker1();
    wk1.start();
    Thread thd = new Thread(new Worker2());
    thd.start();
    try {
        wk1.join();
        thd.join();
    } catch (InterruptedException ie) {
        System.out.println(ie);
    }
        System.out.println("I'm a master");
    }
}