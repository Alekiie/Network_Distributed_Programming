import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

public class NewReadUpstream {
    public static void main(String[] args) {
        URL webpage = null;
        BufferedReader in = null;
        BufferedWriter writer = null;

        try {
            webpage = new URL("https://en.wikipedia.org/wiki/Computer_science");
          
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Cannot find webpage: " + webpage);
            System.exit(-1);
        }
        try {
            URLConnection aConnection = webpage.openConnection();
            in = new BufferedReader(new InputStreamReader(aConnection.getInputStream()));
            // writer = new BufferedWriter(new FileWriter("output.html"));
            String filename = webpage.getFile();
            filename = filename.substring(filename.lastIndexOf('/') + 1);
            
            // Append .html extension
            if (!filename.endsWith(".html")) {
                filename += ".html";
            }
            
            writer = new BufferedWriter(new FileWriter(filename));

        } catch (Exception e) {

            // TODO: handle exception
            System.out.println("Cannot connect to the page: " + webpage);
            System.exit(-1);
        }
        try {
            String lineOfPage;
            while ((lineOfPage = in.readLine()) != null) {
                writer.write(lineOfPage);
                writer.newLine();
            }
            in.close();
            writer.close();

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Cannot read the page: " + webpage);

        }
    }
}
