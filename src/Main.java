import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");

        frame.setSize(650,495);

        Pong pong = new Pong();

        frame.add(pong);

        frame.setVisible(true);


    }
}