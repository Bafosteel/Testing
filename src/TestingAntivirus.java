import java.io.File;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
public class TestingAntivirus {
    protected String antvrTest()
    {
        String result="";
        ExtractFiles ext = new ExtractFiles();
        ext.extract("C:\\Users\\Артём\\Desktop\\eicar.zip","C:\\Users\\Артём\\Desktop\\");
        File f = new File("C:\\Users\\Артём\\Desktop\\eicar.com");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            System.err.println("Something's gone wrong");
        }
        if (f.exists() && !f.isDirectory()){
            result = "Антивирус на данном ПК не работает или неверно настроен";
        }
        else {
            result = "Антивирус на данном ПК работает";
        }

        return result;
    }
}
