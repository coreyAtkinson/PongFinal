


import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import javax.swing.AbstractAction;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.applet.*;
import java.net.*;
import java.io.*;






import java.applet.Applet;

import java.applet.AudioClip;

import java.net.URL;
import java.sql.SQLOutput;

import javax.sound.sampled.*;
public class Pong extends JPanel {
    private int length = 650;
    private int hight = 495;
    private int point1, point2;
    private Ball ball;
    private Paddle p1;
    private Paddle p2;

    private int sBoost;
    Clip sound;
    Clip sad;
    public Pong(){
        ball = new Ball(300,200,1,1,20,255, 255, 255);
        p1 = new Paddle(90,20,20,0,255, 255, 255);
        p2 = new Paddle(90,20,length - 40,0,255, 255, 255);
         point1 = 0;
         point2 = 0;
         sBoost = 1;



        {
            try {
                sound = AudioSystem.getClip();
                sound.open(AudioSystem.getAudioInputStream(new File("src/hit.wav")));
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        {
            try {
                sad = AudioSystem.getClip();
                sad.open(AudioSystem.getAudioInputStream(new File("src/over.wav")));
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        this.setFocusable(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //w = 87, a= 65, s=83, d=68, up= 38, down = 40, right= 39, left= 37
             int code = e.getKeyCode();
                System.out.println(e.getKeyCode());
             if(code == 80)
              {
               ball.setSpeed(1);
               point1 = 0;
               point2 = 0;
              }

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
        setBackground(new Color(17, 16, 17));

        ball.paint(g);
        ball.moveBall();
        ball.bounce();
        p1.paint(g);
        p2.paint(g);

       if(p1.collideR(ball)){
           sBoost++;
           ball.rainbow();

           sound.start();

           {
               try {
                   sound = AudioSystem.getClip();
                   sound.open(AudioSystem.getAudioInputStream(new File("src/hit.wav")));
               } catch (LineUnavailableException e) {
                   throw new RuntimeException(e);
               } catch (UnsupportedAudioFileException e) {
                   throw new RuntimeException(e);
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

           }


          /* try {
               AudioClip clip = Applet.newAudioClip(
                       new URL(“file://c:/blah/hit.wav”));
               clip.play();
           } catch (MalformedURLException murle) {
               System.out.println(murle);
           }
*/

       }
        if(p2.collideL(ball)){
            sBoost++;
            ball.rainbow();

            sound.start();

            {
                try {
                    sound = AudioSystem.getClip();
                    sound.open(AudioSystem.getAudioInputStream(new File("src/hit.wav")));
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }


        }
        if(sBoost >= 2)
        {
            /*
            ball.setSpeed(ball.getSpeedX() + .25);
            p1.setSpeed(p1.getxSpeed() + 5);
            p2.setSpeed(p2.getxSpeed() + 5);
            sBoost = 0;

             */
            ball.rainbow();
            sBoost++;
            if(sBoost >= 5)
                sBoost = 0;
        }

        g.setColor(Color.WHITE);

        g.drawString("Player 1: " + point1 + "    Player 2: " + point2, 250, 20   );

        if(point1 >= 5 || point2 >= 5)
        {
           // ball = null;
            if(point1> point2)
            {

                g.drawString("Player 1 wins! Press P to play again!",250,100);
            }
            else
            {

                g.drawString("Player 2 wins! Press P to play again!", 250,100);
            }
            ball.setSpeed(0);
        }

        if(ball.getX() < 0)
        {
            point2++;
            System.out.println("P2: " + point2);
            ball.setPosition(300,200);
            sBoost = 0;
           // ball.setSpeed(1);
           // p1.setSpeed(10);
           // p2.setSpeed(10);
sad.start();
            {
                try {
                    sad = AudioSystem.getClip();
                    sad.open(AudioSystem.getAudioInputStream(new File("src/over.wav")));
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }



        if(ball.getX() > 650)
        {
            point1++;
            System.out.println("P1: " + point1);
            ball.setPosition(300,200);
           // ball.setSpeed(1);
          //  p1.setSpeed(5);
           // p2.setSpeed(5);
sad.start();
            {
                try {
                    sad = AudioSystem.getClip();
                    sad.open(AudioSystem.getAudioInputStream(new File("src/over.wav")));
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

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
