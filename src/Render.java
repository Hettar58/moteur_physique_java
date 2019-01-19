import org.w3c.dom.css.Rect;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private double movemenetThresold = 0.1;
    private double gravity = 9.81;
    private double dt = 0.16;

    public Render() {
        initRender();
    }

    private void initRender() {
        addKeyListener(new TAdapter());//creation du grabber pour les input.

        setBackground(Color.white);

        squares = new ArrayList<>();
        blocks = new ArrayList<>();


        floor1 = new Floor(0, 570);
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

    }

    public void addSquare(Square square) {
        squares.add(square);
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
                    if (squares.get(i).getX() + 21 >= squares.get(j).getX() && (squares.get(j).getY() < squares.get(i).getY() && squares.get(i).getY() < squares.get(j).getY() + 21)) {
                        squares.get(i).invertVx();
                    }
                    if (squares.get(i).getY() + 21 >= squares.get(j).getY() && (squares.get(j).getX() < squares.get(i).getX() && squares.get(i).getX() < squares.get(j).getX() + 21)) {
                        squares.get(i).invertVy();
                    }
                }
            }

        }
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            for(Square square : squares){
                square.keyReleased(e);
            }

        }

        @Override
        public void keyPressed(KeyEvent e){
            for(Square square : squares){
                square.keyPressed(e);
            }
        }
    }
}
