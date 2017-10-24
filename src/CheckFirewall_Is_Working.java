import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.net.URLConnection;

public class CheckFirewall_Is_Working {
    protected String checkOutpostWork() {
        String result="";
        try{
            URL url = new URL("http://stackoverflow.com/");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = null;
            String red = null;
            while ((s = reader.readLine()) != null) {
                red+=s;
            }
            System.out.println(red);
            if (red != ""){
                result ="Межсетевой экран функционирует неверно, или не функционирует вовсе!";
            }
        }
        catch (IOException e){
            result = "Межсетевой экран функционирует правильно!";
        }
        return result;
    }
}