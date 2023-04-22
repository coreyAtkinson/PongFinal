import javax.swing.*;
import javax.swing.AbstractAction;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends JPanel {
    private int length = 650;
    private int hight = 495;
    private int point1, point2;
    private Ball ball;
    private Paddle p1;
    private Paddle p2;
JLabel l;

    public Pong(){
        ball = new Ball(300,200,1,1,20,100,100,100);
        p1 = new Paddle(90,20,20,0,100,100,100);
        p2 = new Paddle(90,20,length - 40,0,100,100,100);
         point1 = 0;
         point2 = 0;
        l = new JLabel("Test");
        l.setBackground(Color.CYAN);
        l.setLocation(100,100);
        l.setText("helloWorld");
        l.setSize(40,10);
        l.isOpaque();





        this.setFocusable(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //w = 87, a= 65, s=83, d=68, up= 38, down = 40, right= 39, left= 37
             int code = e.getKeyCode();



             if(p1.getY() < 1){
                 p1.setPosition(p1.getX(), 0);

                // p1.moveDown();
             }
             if(p1.getY() > hight - 89-30){
                 p1.setPosition(p1.getX(), hight-89-30);

                 System.out.println("Out x");
             }

                if(p2.getY() < 1){
                    p2.setPosition(p2.getX(), 0);

                    // p1.moveDown();
                }
                if(p2.getY() > hight - 89-30){
                    p2.setPosition(p2.getX(), hight-89-30);

                    System.out.println("Out x");
                }


                if(code == 87)
                    p1.moveUp();
                if(code == 83)
                    p1.moveDown();

                if(code == 38)
                    p2.moveUp();
                if(code == 40)
                    p2.moveDown();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });



    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(255,244,43));

        ball.paint(g);
        ball.moveBall();
        ball.bounce();
        p1.paint(g);
        p2.paint(g);

        p1.collideR(ball);
        p2.collideL(ball);

        if(ball.getX() < 0)
        {
            point2++;
            System.out.println("P2: " + point2);
            ball.setPosition(300,200);
        }

        if(ball.getX() > 650)
        {
            point1++;
            System.out.println("P1: " + point1);
            ball.setPosition(300,200);
        }
        try {
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        };
        repaint();
    }

}
