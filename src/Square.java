
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Square extends Sprite implements MouseListener, MouseMotionListener {
    private double angle;
    private int masse;
    private int velocite;
    private double ax;
    private double ay;
    private double vx;
    private double vy;
    private double dt;
    private double gravity;
    private double absorbtion;
    private double movementThresold;
    private boolean move;
    private boolean mouseInPlace;
    private int mouseX;
    private int mouseY;
    private int mouseX_origin;
    private int mouseY_origin;

    public Square(int x, int y){
        super(x, y);

        this.angle = 45*3.14/180;
        this.masse = 7;
        this.velocite = 2;
        this.ax = 1;
        this.dt = 0.16;
        this.gravity = 9.81;
        this.absorbtion = 0.8;
        this.movementThresold = 0.1;
        this.ay = masse * gravity;
        this.vx = this.velocite * Math.cos(this.angle);
        this.vy = -this.velocite * Math.sin(this.angle);
        this.move = true;

        loadImage("src/res/square.png");
        getImageDimensions();
        System.out.println("created object " + "x="+this.x+" y="+ this.y+" masse="+this.masse+" velocite="+this.velocite+" angle="+this.angle+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);
    }

    public Square(int x, int y, double angle, int masse, int velocite, double dt, double absorbtion, double gravity, double movementThresold){
        super(x, y);

        this.angle = angle*3.14/180;
        this.masse = masse;
        this.velocite = velocite;
        this.ax = 1;
        this.dt = dt;
        this.gravity = gravity;
        this.absorbtion = absorbtion;
        this.movementThresold = movementThresold;
        this.ay = masse * gravity;
        this.vx = this.velocite * Math.cos(this.angle);
        this.vy = -this.velocite * Math.sin(this.angle);
        this.move = true;
        loadImage("src/res/square.png");
        getImageDimensions();
        System.out.println("created object " + "x="+this.x+" y="+ this.y+" masse="+this.masse+" velocite="+this.velocite+" angle="+this.angle+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);

    }

    public void invertVx(){
        this.vx = -this.vx;
    }

    public void invertVy(){ this.vy = -this.vy; }

    public void setDt(double dt){
        this.dt = dt;
    }

    public void setAbsorbtion(double absorbtion){
        this.absorbtion = absorbtion;
    }

    public void setMovementThresold(double movementThresold){
        this.movementThresold = movementThresold;
    }

    public void setGravity(double gravity){
        this.gravity = gravity;
        this.ay = this.masse * this.gravity;
    }

    public void move(){
        if(this.move == true) {
            vx += ax * dt;
            vy += ay * dt;
            x += vx * dt;
            y += vy * dt;
            //System.out.println("x="+this.x+" y="+ this.y+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);

            if (System.getProperty("os.name").equals("Windows 10")) {
                if (y >= 530) {
                    vy = -vy * absorbtion;
                    vx = vx * absorbtion;
                    y = 530;
                }
            } else {
                if (y >= 550) {
                    vy = -vy * absorbtion;
                    vx = vx * absorbtion;
                    y = 550;
                }
            }

            if (Math.abs(this.vy) < movementThresold) {
                ay = 0;
                vy = 0;
                ax = 0;
                vx = 0;
            }
        }
        else{
            this.x = mouseX-10;
            this.y = mouseY-10;
        }
    }

    public void mousePressed(MouseEvent e){
        mouseX_origin = e.getX();
        mouseY_origin = e.getY();
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){
        if (this.move == false){
            int dx = mouseX_origin - mouseX;
            int dy = mouseY_origin - mouseY;
            this.velocite = (int)(Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0)) * 2);
            this.angle = Math.atan2(dy, dx);
            this.vx = -this.velocite * Math.cos(this.angle);
            this.vy = -this.velocite * Math.sin(this.angle);
            this.move = true;
        }

    }
    public void mouseExited(MouseEvent e){}
    public void mouseDragged(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        if (x <= mouseX && mouseX <= x+20 && y <= mouseY && mouseY <= y+20){
            this.move = false;
        }
    }
    public void mouseMoved(MouseEvent e){}
}
