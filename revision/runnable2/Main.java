package revision.runnable2;

class RunnableDemo implements Runnable {
    private String message;

    public RunnableDemo(String message) {
        this.message = message;
    }

    public void run() {
        // while (true) {
            
            System.out.println(message);
        // }
    }

}

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new RunnableDemo("We have Created a  Thread");
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY); // set priority to min

        thread.setName("custom");
        thread.start();
        System.out.println("Main Method terminated...");
    }

}
