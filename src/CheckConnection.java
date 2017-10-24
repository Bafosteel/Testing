import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static sun.rmi.transport.TransportConstants.Ping;

public class CheckConnection {
    protected String check(){
        String result="";
        String ipAdress = "www.yandex.ru";
        try {
            InetAddress inetadd = InetAddress.getByName(ipAdress);
            System.out.println("Sending Ping Request to " + ipAdress);
            boolean ipstatus = inetadd.isReachable(10000);
            if (ipstatus){
                result="Данный компьютер подключен к интернету";
            }
            else
            {
                System.out.println("Что-то не так");
                result="";
            }
        }
        catch (UnknownHostException e){
            System.err.println("Данный компьютер не подключен к интернету");
        }
        catch (IOException e)
        {
            System.err.println("Error");
        }
        return result;
    }
}
