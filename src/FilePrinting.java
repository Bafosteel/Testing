import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinting {
    protected void filePrint(JList d) {
        try {
            FileWriter filer = new FileWriter("C:\\Users\\Boklista.txt");
            PrintWriter out = new PrintWriter(filer);
            for (int i = 0; i < d.getModel().getSize(); i++) {
                Object item = d.getModel().getElementAt(i);
                out.println(item);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}