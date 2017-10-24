import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckAntivirus_Is_Installed {
    protected String checkAvast() {
        String line,lines = "";
        String result="";
        String cmd = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Classes\\avastlicfile";
        try {
            Process proc = Runtime.getRuntime().exec("reg query " + cmd);
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = reader.readLine()) != null) {
                lines+=line;
            }
            String check[] = lines.split(" ");

            for (String word:check){
                if (word.matches("avast!")) {
                    result = "Антивирус Avast установлен в системе!";
                    break;
                }
                else{
                    result="Антивирус Avast не установлен в системе!";
                }
            }


        }
        catch (Exception e) {
            System.err.println("Что-то пошло не так!");
        }
        return result;
    }
}