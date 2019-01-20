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

        JButton ajoutSquare = new JButton("Créer");
        ajoutSquare.setBounds(0, 0, 100, 25);
        ajoutSquare.addActionListener(new AddSquareFrame(render));

        JButton supprSquare = new JButton("Supprimer");
        supprSquare.setBounds(100, 0, 125, 25);
        supprSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render.removeSquare();
            }
        });

        JButton params = new JButton("Paramètres");
        params.setBounds(225, 0, 125, 25);
        params.addActionListener(new ParamsFrame(render));

        Square square1 = new Square(100, 100, 75.0, 10, 100, render.getDt(), render.getAbsorbtion(), render.getGravity(), render.getMovemenetThresold());
        Square square2 = new Square(1,1);

        Block block1 = new Block(200, 0);

        render.add(ajoutSquare);
        render.add(supprSquare);
        render.add(params);
        render.addSquare(square1);
        render.addSquare(square2);
        render.addBlock(block1);

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
