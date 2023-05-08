import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setSize(650,495);
//frame.setLayout(new BorderLayout());
        //  JLabel l = new JLabel("P1: 0    P2: 0");
      //  l.setBackground(Color.CYAN);
      //  l.setHorizontalAlignment(JLabel.CENTER);
       // l.setLocation(350,0);
      //  l.setText("P1: ");
      //  l.setSize(40,10);



Pong pong = new Pong();


        frame.add(pong, BorderLayout.CENTER);
    //  frame.add(l, BorderLayout.NORTH);
        frame.setVisible(true);


    }
}