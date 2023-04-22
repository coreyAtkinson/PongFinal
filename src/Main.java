import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setSize(650,495);

        JLabel l = new JLabel("Test");
        l.setBackground(Color.CYAN);
        l.setLocation(100,100);
        l.setText("helloWorld");
        l.setSize(40,10);
        l.isOpaque();


        Pong pong = new Pong();


        frame.add(pong);
       // frame.add(l);
        frame.setVisible(true);


    }
}