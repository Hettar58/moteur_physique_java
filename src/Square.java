import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Square {
    private double x;
    private double y;
    private double angle = 45*3.14/180;
    private int masse = 3;
    private int velocite = 5;
    private double ax = 0;
    private double ay = masse * 9.81;
    private double vx = velocite * Math.cos(angle);
    private double vy = -velocite * Math.sin(angle);
    private Image image;
    private double dt = 0.1;

    public Square(){
        loadImage();
    }

    private void loadImage(){
        ImageIcon ii = new ImageIcon("src/res/square.png");
        image = ii.getImage();
    }

    public void move(){

        if((int)y >= 560){
            vy = -vy * 0.8;
            vx = vx * 0.8;
        }

        if (Math.abs((int)vx) < 0.1){
            ax = 0;
        }
        if (Math.abs((int)vy) < 0.1){
            ay = 0;
        }
        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt;
        y += vy * dt;

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
    }
    public Image getImage(){ return image;}
    public double getX(){ return x;}
    public double getY(){ return y;}
}
