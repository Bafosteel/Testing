import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckAntivirus_Is_Working {
    protected String checkAvastWork(){
        String result ="";
        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if(line.contains("AvastSvc")){
                    result = "Антивирус Avast работает!";
                }
            }
            if(result==""){
                result = "Антивирус Avast не работает!";
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return result;
    }
}
