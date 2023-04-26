import javax.swing.*;
import java.awt.*;
public class Ball{
    int x, y;
    double speedX, speedY;
    int size;
    int c1, c2, c3;

    public Ball(int x, int y, double speedX, double speedY, int size, int c1, int c2, int c3){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.size = size;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;

    }


    public void paint(Graphics g){


        g.setColor(new Color(c1,c2,c3));


        g.fillOval(x, y, size, size);

    }
    public void moveBall(){
        x += speedX;
        y += speedY;
    }
    public void bounce(){
        if(y < 0)
            speedY *= -1;
        if(y > 435)
            speedY *= -1;
/*
        if(x < 0)
            speedX *= -1;
        if(x > 700)
            speedX *= -1;
*/
    }

    public void changeSpeedY() {
        speedY *= -1;
    }
    public void changeSpeedX() {
        speedX *= -1;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
