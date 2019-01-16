import java.awt.*;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//le rendu et la gestion des inputs se font dans la même classe.
public class Render extends JPanel{
    private Timer timer;
    private Square square1;
    private final int PERIOD_INTERVAL = 16;
    private final int INITIAL_DELAY = 250;


    public Render(){
        initRender();
    }

    private void initRender(){
        addKeyListener(new TAdapter());//creation du grabber pour les input.

        setBackground(Color.white);

        square1 = new Square();

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), INITIAL_DELAY, PERIOD_INTERVAL);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(square1.getImage(), (int)square1.getX(), (int)square1.getY(), this);
    }

    private class ScheduleTask extends TimerTask{
        @Override
        public void run(){
            repaint((int)square1.getX()-1, (int)square1.getY()-1, 22, 22);
            square1.move();
            repaint((int)square1.getX(), (int)square1.getY(), 20, 20);
        }
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            square1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            square1.keyPressed(e);
        }
    }
}
