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
                JFrame popupFrame = new JFrame();
                popupFrame.setLayout(new FlowLayout());
                JTextField xInput = new JTextField(10);
                JTextField yInput = new JTextField(10);
                JTextField masseInput = new JTextField(10);
                JTextField angleInput = new JTextField(10);
                JTextField velociteInput = new JTextField(10);
                popupFrame.setTitle("Créer un nouvel objet");
                popupFrame.add(new JLabel("Entrez la position X"));
                popupFrame.add(xInput);
                popupFrame.add(new JLabel("Entrez la position Y"));
                popupFrame.add(yInput);
                popupFrame.add(new JLabel("Entrez la masse de l'objet"));
                popupFrame.add(masseInput);
                popupFrame.add(new JLabel("Entrez l'angle de la trajectoire"));
                popupFrame.add(angleInput);
                popupFrame.add(new JLabel("Entrez la vélocité de l'objet"));
                popupFrame.add(velociteInput);
                JButton closePopup = new JButton("OK");
                popupFrame.add(closePopup);

                popupFrame.setSize(240, 300);
                popupFrame.setVisible(true);

                closePopup.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = Integer.parseInt(xInput.getText());
                        int y = Integer.parseInt(yInput.getText());
                        int masse = Integer.parseInt(masseInput.getText());
                        double angle = Double.parseDouble(angleInput.getText());
                        int velocite = Integer.parseInt(velociteInput.getText());
                        render.addSquare(new Square(x, y, angle, masse, velocite, 0.16, 0.8, 9.81, 0.1));
                        popupFrame.dispose();
                    }
                });
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

        JButton params = new JButton("Paramètres");
        params.setBounds(225, 0, 100, 25);
        params.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame popupFrame = new JFrame();

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
