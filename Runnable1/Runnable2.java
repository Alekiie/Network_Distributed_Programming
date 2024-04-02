package Runnable1;

 class Runnable2Demo implements Runnable {
  private  String message;
   public Runnable2Demo(String message){
    this.message=message;
    }

    public void run(){
        System.out.println(message);
    }
    
}
public class Runnable2 {

    public static void main(String[] args) {
        Runnable exam =new Runnable2Demo("Go for exams");
        Thread thread =new Thread(exam);
        thread.setDaemon(true);
        thread.start();
        System.out.println("End of thread");
    }
}
