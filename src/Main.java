import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        TimeStampDisp timeStampDisp1 = new TimeStampDisp();
        TimeStampDisp timeStampDisp2 = new TimeStampDisp();
        JFrame frame = new JFrame("Task2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel infoPanel = new JPanel(new GridLayout(1,2));
        JPanel funcPanel = new JPanel(new GridLayout(1,2));
        JScrollPane scroll1 = new JScrollPane(timeStampDisp1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scroll2 = new JScrollPane(timeStampDisp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JButton button1 = new JButton("SUSP");
        JButton button2 = new JButton("SUSP");

        infoPanel.add(scroll1);
        infoPanel.add(scroll2);
        funcPanel.add(button1);
        funcPanel.add(button2);
        frame.add(infoPanel,BorderLayout.CENTER);
        frame.add(funcPanel,BorderLayout.SOUTH);
        frame.setSize(500,500);
        frame.setVisible(true);
        Thread thread = new Thread(timeStampDisp1);
        Thread thread1 = new Thread(timeStampDisp2);
        thread.start();
        thread1.start();
        button1.addActionListener(e->{
            if (button1.getText().equals("SUSP")){
                timeStampDisp1.sleep();
                button1.setText("RUN");
            }else {
                timeStampDisp1.resume();
                button1.setText("SUSP");
            }
        });
        button2.addActionListener(e->{
            if (button2.getText().equals("SUSP")){
                timeStampDisp2.sleep();
                button2.setText("RUN");
            }else {
                timeStampDisp2.resume();
                button2.setText("SUSP");
            }
        });
    }
}