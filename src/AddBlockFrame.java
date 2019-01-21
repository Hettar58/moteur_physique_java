import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBlockFrame extends JFrame implements ActionListener {
    private Render render;
    private JTextField xInput;
    private JTextField yInput;
    private JButton closePopup;
    private JLabel xLabel;
    private JLabel yLabel;

    public AddBlockFrame(Render render){
        this.render = render;
        this.xInput = new JTextField(10);
        this.yInput = new JTextField(10);
        this.closePopup = new JButton("OK");
        this.xLabel = new JLabel("Entrez la position X");
        this.yLabel = new JLabel("Entrez la position Y");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == closePopup){
            createBlock();
        }
        else{
            this.setLayout(new FlowLayout());
            this.setTitle("Créer un block");
            this.add(xLabel);
            this.add(xInput);
            this.add(yLabel);
            this.add(yInput);
            this.add(closePopup);

            this.setSize(200, 300);
            this.setVisible(true);
            closePopup.addActionListener(this);
        }
    }

    private void createBlock(){
        int x = Integer.parseInt(xInput.getText());
        int y = Integer.parseInt(yInput.getText());
        Block block = new Block(x, y);
        render.addBlock(block);
        this.dispose();
    }
}
