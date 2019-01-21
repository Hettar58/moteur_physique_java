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
    private JLabel xLabel;
    private JLabel yLabel;
    private JLabel masseLabel;
    private JLabel angleLabel;
    private JLabel velociteLabel;


    public AddSquareFrame(Render render){
        xInput = new JTextField(10);
        yInput = new JTextField(10);
        masseInput = new JTextField(10);
        angleInput = new JTextField(10);
        velociteInput = new JTextField(10);
        closePopup = new JButton("OK");
        xLabel = new JLabel("Entrez la position X");
        yLabel = new JLabel("Entrez la position Y");
        masseLabel = new JLabel("Entrez la masse de l'objet");
        angleLabel = new JLabel("Entrez l'angle de la trajectoire de l'objet");
        velociteLabel = new JLabel("Entrez la vélocité de l'objet");
        this.render = render;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closePopup){
            this.createSquare();
        } else {
            this.setLayout(new FlowLayout());
            this.setTitle("Créer un nouvel objet");
            this.add(xLabel);
            this.add(xInput);
            this.add(yLabel);
            this.add(yInput);
            this.add(masseLabel);
            this.add(masseInput);
            this.add(angleLabel);
            this.add(angleInput);
            this.add(velociteLabel);
            this.add(velociteInput);
            this.add(closePopup);
            this.setSize(240, 350);
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
        Square square = new Square(x, y, angle, masse, velocite, render.getDt(), render.getAbsorbtion(), render.getGravity(), render.getMovemenetThresold());
        render.addSquare(square);
        this.dispose();
    }
}
