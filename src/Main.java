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
        JMenuBar barre = new JMenuBar();
        JMenu menuAjout = new JMenu("Ajouter");
        JMenu menuSupprimer = new JMenu("Supprimer");
        JMenu menuParams = new JMenu("Paramètres");
        JMenuItem ajoutSquare = new JMenuItem("Ajouter un square");
        ajoutSquare.addActionListener(new AddSquareFrame(render));

        JMenuItem ajoutBlock = new JMenuItem("Ajouter un block");
        ajoutBlock.addActionListener(new AddBlockFrame(render));

        JMenuItem supprSquare = new JMenuItem("Supprimer");
        supprSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render.removeSquare();
            }
        });

        JMenuItem params = new JMenuItem(" accéder aux paramètres");
        params.addActionListener(new ParamsFrame(render));

        Square square1 = new Square(100, 100, 75.0, 10, 100, render.getDt(), render.getAbsorbtion(), render.getGravity(), render.getMovemenetThresold());
        Square square2 = new Square(1,1);

        Block block1 = new Block(200, 0);

        menuParams.add(params);
        menuAjout.add(ajoutSquare);
        menuAjout.add(ajoutBlock);
        menuSupprimer.add(supprSquare);

        barre.add(menuAjout);
        barre.add(menuSupprimer);
        barre.add(menuParams);
        setJMenuBar(barre);

        render.addSquare(square1);
        render.addSquare(square2);
        render.addBlock(block1);

        setTitle("Moteur Physique 2D");
        setSize(800, 620);

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
