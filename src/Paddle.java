import javax.swing.*;
import java.awt.*;
public class Paddle{
    private int hight, width;
    private int x, y;
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
    }

    public void paint(Graphics g){

        g.setColor(new Color(c1,c2,c3));
        g.fillRect(x, y, width, hight);

    }
    public void moveUp(){
        y += 1;
    }
    public void moveDown(){
        y -= 1;
    }
}
