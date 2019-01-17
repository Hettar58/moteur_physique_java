import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame{

    public Main(){
        initUI();
    }

    private void initUI(){
        Render render = new Render();
        render.setLayout(null);
        add(render);

        JButton ajoutSquare = new JButton("Add Square");
        ajoutSquare.setBounds(0, 0, 100, 25);
        ajoutSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Entrez la position X", null));
                int y = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "entrez la position Y", null));
                int masse = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Entrez la masse de l'objet", null));
                double angle = Double.parseDouble(JOptionPane.showInputDialog(new JFrame(), "Entrez l'angle de la trajectoire de l'objet", null));
                int velocite = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Entrez la vélocité de l'objet", null));
                render.addSquare(new Square(x, y, angle, masse, velocite));
            }
        });

        JButton supprSquare = new JButton("Remove Square");
        supprSquare.setBounds(100, 0, 125, 25);
        supprSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render.removeSquare();
            }
        });

        Square square1 = new Square(100, 100, 75.0, 10, 100);
        Square square2 = new Square(1,1);

        render.add(ajoutSquare);
        render.add(supprSquare);
        render.addSquare(square1);
        render.addSquare(square2);

        setTitle("Moteur Physique 2D");
        setSize(800, 600);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String[] args){
        EventQueue.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
