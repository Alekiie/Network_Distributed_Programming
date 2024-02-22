import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadUpStream {
    public static void main(String[] args) {
        URL webpage = null;
        try {
            webpage = new URL("https://en.wikipedia.org/wiki/Computer_science");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(webpage.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.html"));

            // Now read the webpage file
            String lineOfWebPage;
            while ((lineOfWebPage = in.readLine()) != null) {

                writer.write(lineOfWebPage);
                writer.newLine(); // Add newline character
                // System.out.println(lineOfWebPage);
            }
            writer.close();
            in.close(); // Close the connection to the net
        } catch (MalformedURLException e) {
            System.out.println("Cannot find webpage " + webpage);
        } catch (IOException e) {
            System.out.println("Cannot read from webpage " + webpage);
        }
    }
}
