package revision.runnable;

//class implements Runnable interface
class RunnableDemo implements Runnable {
    private String message;

    //     //class constructor  
    public RunnableDemo(String message) {
        this.message = message;
    }

    //    //run method
    public void run() {
        while (true) {
            System.out.println(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // create first thread instance hello
        Runnable hello = new RunnableDemo("Hello, Greetings!!!");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);// set this thread as daemon
        thread1.setName("hello");
        System.out.println("Starting First thread...");
        // start the thread
        thread1.start();
        // create second thread instance bye     
        Runnable bye = new RunnableDemo("Bye for now!!");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY); // set priority to min
        thread2.setDaemon(true); // set as daemon thread
        System.out.println("Starting goodbye thread...");
        // start the thread
        thread2.start();
        System.out.println("main() is ending...");
    }
}
