import java.io.File;

public class CheckFirewall_Is_Installed {
    protected String checkOutpost(){
        String result ="";
        File f = new File("C:/Program Files/Agnitum/Outpost Firewall Pro/op_mon.exe");
        if (f.exists() && !f.isDirectory())
        {
            result = "Фаерволл Outpost установлен!";
        }
        else
        {
            result = "Фаерволл Outpost не установлен!";
        }
        return result;
    }
}
