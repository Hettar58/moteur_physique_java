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

        Square square1 = new Square(100, 100, 75.0, 10, 100);
        Square square2 = new Square(1,1);

        render.addSquare(square1);
        render.addSquare(square2);

        JButton ajoutSquare = new JButton("Add Square");
        ajoutSquare.setLocation(0, 0);
        ajoutSquare.setBounds(0, 0, 100, 25);
        ajoutSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render.addSquare(new Square(400, 400));
            }
        });

        render.add(ajoutSquare);

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
