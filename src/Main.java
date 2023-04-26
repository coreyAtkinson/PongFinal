import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setSize(650,495);
frame.setLayout(new BorderLayout());
        JLabel l = new JLabel("Test");
        l.setBackground(Color.CYAN);
        l.setLocation(350,0);
        l.setText("helloWorld");
        l.setSize(40,10);

JPanel top = new JPanel();
top.setLayout(new GridLayout(1, 3));
Pong pong = new Pong();

frame.add(top, BorderLayout.NORTH);
        frame.add(pong, BorderLayout.CENTER);
      frame.add(l, BorderLayout.NORTH);
        frame.setVisible(true);


    }
}