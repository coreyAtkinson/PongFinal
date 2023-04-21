import javax.swing.*;
import java.awt.*;
public class Pong extends JPanel {
    private int length = 650;
    private int hight = 495;
    private Ball ball;
    private Paddle p1;
    private Paddle p2;
    public Pong(){
        ball = new Ball(300,200,3,3,20,100,100,100);
        p1 = new Paddle(90,20,20,hight/2,100,100,100);
        p2 = new Paddle(90,20,length - 40,hight/2,100,100,100);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(255,244,43));

        ball.paint(g);
        ball.moveBall();
        ball.bounce();
        p1.paint(g);
        p2.paint(g);
        try {
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        };
        repaint();
    }

}
