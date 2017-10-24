import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KursachForm extends JFrame{
    private JPanel rootpanel;
    private JButton button1;
    private JButton button2;
    private JList list1;
    private JScrollPane scroll;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button3;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JButton button4;
    private JTextField textField4;
    private JButton button5;
    private JTextField textField5;
    private JButton button6;
    private JButton button7;
    private JTextField textField6;
    private JButton button8;
    private JButton button9;
    private JLabel label3;

    public KursachForm() {

        /*
        Объявление основных параметров и размеров формы
        */


        super("Программа проверки информационной безопасности");
        DefaultListModel model = new DefaultListModel();
        setContentPane(rootpanel);
        setVisible(true);
        setResizable(false);
        setSize(780,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rootpanel.setLayout(null);

        /*
        Объявление основных параметров кнопок и меток, связанных с
        проверкой межсетевого экрана
         */


        label1.setText("Проверка межсетевого экрана");
        label1.setBounds(15,3,180,15);
        button1.setText("<html>Проверка подключения к интернету</html>");
        button1.setBounds(15,20,280,35);
        textField1.setBounds(300,20,400,35);
        button2.setText("<html>Проверка наличия установленного межсетевого экрана</html>");
        button2.setBounds(15,60,280,35);
        textField2.setBounds(300,60,400,35);
        button3.setText("<html>Проверка работоспособности межсетевого экрана</html>");
        button3.setBounds(15,100,280,35);
        textField3.setBounds(300,100,400,35);

        /*
        Объявление размеров и заголовка для элементов JList и JScroll
         */


        label3.setText("<html>Результаты проверок и рекомендации</html>");
        label3.setBounds(15,310,250,20);
        scroll.setBounds(15,332,400,129);
        list1.setBounds(15,332,400,129);

        /*
        Объявление основных параметров кнопок и меток, связанных с
        проверкой антивирусного программного обеспечения
         */


        label2.setText("Проверка антивирусного программного обеспечения");
        label2.setBounds(15,155,311,20);
        button4.setText("<html>Проверка наличия установленного антивируса</html>");
        button4.setBounds(15,177,280,35);
        textField4.setBounds(300,177,400,35);
        button5.setText("<html>Проверка работоспособности антивирусного ПО</html>");
        button5.setBounds(15,217,280,35);
        textField5.setBounds(300,217,400,35);
        button6.setText("<html>Тестирование антивирусного ПО</html>");
        button6.setBounds(15,257,280,35);
        textField6.setBounds(300,257,400,35);

        /*
        ОБъясвление параметров кнопок и текстовыъ полей, связанных с
         выводом результатов и записью в файл
         */


        button7.setText("<html>Вывести результаты</html>");
        button7.setBounds(420,332,100,35);
        button8.setText("<html>Сохранить результаты в файл</html>");
        button8.setBounds(420,372,100,49);
        button9.setText("<html>Выход</html>");
        button9.setBounds(420,426,100,35);


        //Проверка межсетевого экрана


        //Проверка наличия подключения к интернету
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckConnection chk = new CheckConnection();
                String connect = chk.check();
                textField1.setText(connect);
            }
        });

        //Проверка наличия установленного МЭ
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckFirewall_Is_Installed chkfrwl = new CheckFirewall_Is_Installed();
                String firewall = chkfrwl.checkOutpost();
                textField2.setText(firewall);
            }
        });

        //Проверка работоспособности МЭ
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckFirewall_Is_Working frwl = new CheckFirewall_Is_Working();
                String res = frwl.checkOutpostWork();
                textField3.setText(res);
            }
        });


        //Проверка Антивирусного программного обеспечения


        //Проверка наличия установленного антивирусного ПО
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAntivirus_Is_Installed antivir = new CheckAntivirus_Is_Installed();
                String avast = antivir.checkAvast();
                textField4.setText(avast);
            }
        });

        //Проверка работоспособности антивируса
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAntivirus_Is_Working antwork = new CheckAntivirus_Is_Working();
                String avst =  antwork.checkAvastWork();
                textField5.setText(avst);
            }
        });

        //Тестирование антивируса
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestingAntivirus test = new TestingAntivirus();
                String virustest = test.antvrTest();
                textField6.setText(virustest);
            }
        });


        //Вывод результатов в JList
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement("1. "+textField1.getText());
                list1.setModel(model);
                model.addElement("2. "+textField2.getText());
                list1.setModel(model);
                model.addElement("3. "+textField3.getText());
                list1.setModel(model);
                model.addElement("4. "+textField4.getText());
                list1.setModel(model);
                model.addElement("5. "+textField5.getText());
                list1.setModel(model);
                model.addElement("6. "+textField6.getText());
            }
        });

        //Запись в файл
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilePrinting file = new FilePrinting();
                file.filePrint(list1);
            }

            //Выход из программы
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }
}
