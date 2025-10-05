package URLConnection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class url_connection{
public static void main(String[] args) {
    try {

//        URL url = new URL("https://www.udemy.com/");

        URL url = new URL("https://www.w3schools.com/");
        java.net.URLConnection urlConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        System.out.println(sb.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
        }