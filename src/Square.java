import java.awt.event.KeyEvent;

public class Square extends Sprite{
    private double angle;
    private int masse;
    private int velocite;
    private double ax;
    private double ay;
    private double vx;
    private double vy;
    private double dt = 0.16;

    public Square(int x, int y){
        super(x, y);

        this.angle = 45*3.14/180;
        this.masse = 7;
        this.velocite = 2;
        this.ax = 1;
        this.ay = masse * 9.81;
        this.vx = this.velocite * Math.cos(this.angle);
        this.vy = -this.velocite * Math.sin(this.angle);

        loadImage("src/res/square.png");
        getImageDimensions();
        System.out.println("created object " + "x="+this.x+" y="+ this.y+" masse="+this.masse+" velocite="+this.velocite+" angle="+this.angle+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);
    }

    public Square(int x, int y, double angle, int masse, int velocite){
        super(x, y);

        this.angle = angle*3.14/180;
        this.masse = masse;
        this.velocite = velocite;
        this.ax = 1;
        this.ay = masse * 9.81;
        this.vx = this.velocite * Math.cos(this.angle);
        this.vy = -this.velocite * Math.sin(this.angle);

        loadImage("src/res/square.png");
        getImageDimensions();
        System.out.println("created object " + "x="+this.x+" y="+ this.y+" masse="+this.masse+" velocite="+this.velocite+" angle="+this.angle+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);

    }

    public void move(){

        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt;
        y += vy * dt;
        //System.out.println("x="+this.x+" y="+ this.y+" vx="+ vx+" vy="+vy+" ax="+ ax+ " ay="+ ay);
        if(y >= 550){
            vy = -vy * 0.8;
            vx = vx * 0.8;
            y = 550;
        }

        if (Math.abs(this.vy) < 0.1){
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
