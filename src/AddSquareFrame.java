import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSquareFrame extends JFrame implements ActionListener {
    private Render render;
    private JTextField xInput;
    private JTextField yInput;
    private JTextField masseInput;
    private JTextField angleInput;
    private JTextField velociteInput;
    private JButton closePopup;

    public AddSquareFrame(Render render){
        xInput = new JTextField(10);
        yInput = new JTextField(10);
        masseInput = new JTextField(10);
        angleInput = new JTextField(10);
        velociteInput = new JTextField(10);
        closePopup = new JButton("OK");
        this.render = render;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closePopup){createSquare();}
        else {
            this.setLayout(new FlowLayout());

            this.setTitle("Créer un nouvel objet");
            this.add(new JLabel("Entrez la position X"));
            this.add(xInput);
            this.add(new JLabel("Entrez la position Y"));
            this.add(yInput);
            this.add(new JLabel("Entrez la masse de l'objet"));
            this.add(masseInput);
            this.add(new JLabel("Entrez l'angle de la trajectoire"));
            this.add(angleInput);
            this.add(new JLabel("Entrez la vélocité de l'objet"));
            this.add(velociteInput);

            this.add(closePopup);

            this.setSize(240, 300);
            this.setVisible(true);

            closePopup.addActionListener(this);
        }
    }

    private void createSquare(){
        int x = Integer.parseInt(xInput.getText());
        int y = Integer.parseInt(yInput.getText());
        int masse = Integer.parseInt(masseInput.getText());
        double angle = Double.parseDouble(angleInput.getText());
        int velocite = Integer.parseInt(velociteInput.getText());
        render.addSquare(new Square(x, y, angle, masse, velocite, render.getDt(), render.getAbsorbtion(), render.getGravity(), render.getMovemenetThresold()));
        this.dispose();
    }
}
