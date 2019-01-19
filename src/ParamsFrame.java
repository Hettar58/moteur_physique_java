import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParamsFrame extends JFrame implements ActionListener {
    private Render render;
    private JButton editDt;
    private JButton editAbsorbtion;
    private JButton editGravity;
    private JButton editMovementThresold;
    private JLabel dtLabel;
    private JLabel absorbtionLabel;
    private JLabel gravityLabel;
    private JLabel movementThresoldLabel;

    public ParamsFrame(Render render){
        this.render = render;
        editDt = new JButton("modifier");
        editAbsorbtion = new JButton("modifier");
        editGravity = new JButton("modifier");
        editMovementThresold = new JButton("modifier");
        dtLabel = new JLabel(" dt: "+render.getDt());
        absorbtionLabel = new JLabel(" Absorbtion: "+render.getAbsorbtion());
        gravityLabel = new JLabel(" Gravity: "+render.getGravity());
        movementThresoldLabel = new JLabel(" MovementThresold: "+render.getMovemenetThresold());

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editDt){
            double dt = Double.parseDouble(JOptionPane.showInputDialog(this, "Entrez la nouvelle valeur", null));
            render.setDt(dt);
            System.out.println("dt modified: "+dt);
        }
        else{
            if(e.getSource() == editMovementThresold){
                double movementThresold = Double.parseDouble(JOptionPane.showInputDialog(this, "entrez la nouvelle valeur", null));
                render.setMovemementThresold(movementThresold);
                System.out.println("MovementThresold modified: "+movementThresold);
            }
            else{
                if(e.getSource() == editGravity){
                    double gravity = Double.parseDouble(JOptionPane.showInputDialog(this, "entrez la nouvelle valeur", null));
                    render.setGravity(gravity);
                    System.out.println("gravity modified: "+gravity);
                }
                else {
                    if(e.getSource() == editAbsorbtion){
                        double absorbtion = Double.parseDouble(JOptionPane.showInputDialog(this, "Entrez la nouvelle valeur", null));
                        render.setAbsorbtion(absorbtion);
                        System.out.println("absorbtion modified: "+absorbtion);
                    }
                    else{
                        this.setLayout(new GridLayout(4, 2));

                        this.add(dtLabel);
                        this.add(editDt);
                        this.add(absorbtionLabel);
                        this.add(editAbsorbtion);
                        this.add(gravityLabel);
                        this.add(editGravity);
                        this.add(movementThresoldLabel);
                        this.add(editMovementThresold);

                        this.setSize(300, 200);
                        this.setVisible(true);
                        editDt.addActionListener(this);
                        editAbsorbtion.addActionListener(this);
                        editGravity.addActionListener(this);
                        editMovementThresold.addActionListener(this);
                    }
                }
            }
        }

    }
}
