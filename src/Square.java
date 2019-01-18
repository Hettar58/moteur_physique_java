import java.awt.event.KeyEvent;

public class Square extends Sprite{
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

        loadImage("src/res/square.png");
        getImageDimensions();
        System.out.println("created object " + "x="+this.x+" y="+ this.y+" masse="+this.masse+" velocite="+this.velocite+" angle="+this.angle+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);

    }

    public void invertVx(){
        this.vx = -this.vx;
    }

    public void invertVy(){ this.vy = -this.vy; }

    public void move(){
        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt;
        y += vy * dt;
        //System.out.println("x="+this.x+" y="+ this.y+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);
        if(y >= 550){
            vy = -vy * absorbtion;
            vx = vx * absorbtion;
            y = 550;
        }
        if (Math.abs(this.vy) < movementThresold){
            ay = 0;
            vy = 0;
            ax = 0;
            vx = 0;
        }
    }



    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
    }


}
