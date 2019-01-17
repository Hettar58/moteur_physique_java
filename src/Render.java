import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


//le rendu et la gestion des inputs se font dans la même classe.
public class Render extends JPanel implements ActionListener{
    private Timer timer;
    private List<Square> squares;
    private List<Block> blocks;
    private Square square1;
    private Floor floor1;
    private final int DELAY = 20;

    public Render(){
        initRender();
    }

    private void initRender(){
        addKeyListener(new TAdapter());//creation du grabber pour les input.

        setBackground(Color.white);

        squares = new ArrayList<>();
        blocks = new ArrayList<>();


        floor1 = new Floor(0, 570);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(floor1.getImage(),floor1.getX(), floor1.getY(), this);
        for(Square square : squares){
            g2d.drawImage(square.getImage(), square.getX(), square.getY(), this);
        }

    }

    public void addSquare(Square square){
        squares.add(square);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(Square square : squares){
            square.move();
        }

        repaint();
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
