import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;


//le rendu et la gestion des inputs se font dans la même classe.
public class Render extends JPanel implements ActionListener {
    private Timer timer;
    private List<Square> squares;
    private List<Block> blocks;
    private Square square1;
    private Floor floor1;

    private int DELAY = 16;
    private double absorbtion = 0.8;
    private double movemenetThresold = 0.01;
    private double gravity = 9.81;
    private double dt = 0.16;

    public Render() {
        initRender();
    }

    private void initRender() {
        setBackground(Color.white);

        squares = new ArrayList<>();
        blocks = new ArrayList<>();

        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").equals("Windows 10")){
            floor1 = new Floor(0, 550);
        }
        else{
            floor1 = new Floor(0, 570);
        }
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(floor1.getImage(), floor1.getX(), floor1.getY(), this);
        for (Square square : squares) {
            g2d.drawImage(square.getImage(), square.getX(), square.getY(), this);
        }
        for(Block block : blocks){
            g2d.drawImage(block.getImage(), block.getX(), block.getY(), this);
        }
    }

    public void addSquare(Square square) {
        addMouseListener(square);
        addMouseMotionListener(square);
        squares.add(square);
    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    public void removeSquare() {
        if (squares.size() != 0) {
            squares.remove(squares.size() - 1);
        }
    }

    public void setAbsorbtion(double absorbtion){
        this.absorbtion = absorbtion;
        for(Square square : squares){
            square.setAbsorbtion(absorbtion);
        }
    }

    public void setMovemementThresold(double movementThresold){
        this.movemenetThresold = movementThresold;
        for (Square square : squares){
            square.setMovementThresold(movementThresold);
        }
    }

    public void setGravity(double gravity){
        this.gravity = gravity;
        for(Square square : squares){
            square.setGravity(gravity);
        }
    }

    public void setDt(double dt){
        this.dt = dt;
        for (Square square : squares){
            square.setDt(dt);
        }
    }

    public double getDt(){return this.dt;}
    public double getAbsorbtion(){return this.absorbtion;}
    public double getMovemenetThresold(){return this.movemenetThresold;}
    public double getGravity(){return this.gravity;}

    @Override
    public void actionPerformed(ActionEvent e){
        for(Square square : squares){
            square.move();
        }
        checkCollisions();
        repaint();
    }

    private void checkCollisions(){
        for (int i = 0; i < squares.size(); i++){
            for (int j = 0;j < squares.size(); j++){
                if (i != j) {
                    Square sq1 = squares.get(i);
                    Square sq2 = squares.get(j);
                    if(sq1.getBounds().intersects(sq2.getBounds())){
                        sq1.invertVx();
                        sq1.invertVy();
                    }
                }
            }
            for (int j = 0; j < blocks.size(); j++) {
                Block bq1 = blocks.get(j);
                Square sq = squares.get(i);
                if (sq.getBounds().intersects(bq1.getBounds())) {
                    sq.invertVx();
                    sq.invertVy();
                }
            }
        }
    }
}
