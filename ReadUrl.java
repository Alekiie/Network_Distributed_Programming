import java.net.MalformedURLException;
import java.net.URL;

public class ReadUrl{
    public static void main(String[] args) {
        // System.out.println("Hello");
        URL webpage = null;
        try {
            webpage =new URL("https://e-learning.embuni.ac.ke/login/index.php");
        } catch (MalformedURLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(webpage);
        System.out.println("protocol: "+webpage.getProtocol());
        System.out.println("Host: "+webpage.getHost());
        System.out.println("Filename: "+ webpage.getFile());
        System.out.println("Port: "+webpage.getPort());
        System.out.println("Ref: "+webpage.getRef());
    }
}