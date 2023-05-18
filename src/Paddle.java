import javax.swing.*;
import java.awt.*;
public class Paddle{
    private int hight, width;
    private int x, y;
    private int xSpeed, ySpeed;
    private int c1, c2, c3;


    public Paddle(int hight, int width, int x, int y, int c1, int c2, int c3)
    {
        this.hight = hight;
        this.width = width;
        this.x = x;
        this.y = y;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        xSpeed = 20;
        ySpeed  = 20;

    }

    public void paint(Graphics g){

        g.setColor(new Color(c1,c2,c3));
        g.fillRect(x, y, width, hight);

    }
    public void moveUp(){
        y -= ySpeed;

    }
    public void moveDown(){
        y += ySpeed;

    }


    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }



    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean collideR(Ball ball){
        if(( ball.getX() < x + width && ball.getX() > x) && (ball.getY() > y && ball.getY() < y + hight)) {
            ball.changeSpeedX();
            return true;
        }
        return false;

    }

    public boolean collideL(Ball ball){
        if((ball.getX() > (x -20) && ball.getX() < x + width) && (ball.getY() > y && ball.getY() < y + hight )) {
            ball.changeSpeedX();
            return true;
        }
        return false;
    }

    public void setSpeed(int s){
        xSpeed = s;
        ySpeed = s;
    }
    public int getxSpeed()
    {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void movePaddle(){
        y += ySpeed;
    }
}
