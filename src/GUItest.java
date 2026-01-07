import javax.swing.*;
import java.awt.*;

public class GUItest {

    private JFrame frame;
    private JPanel panel;

    public GUItest() {
        frame = new JFrame("Darts Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();





        frame.setContentPane(panel);
        frame.setSize(500, 400);
    }
    public void show() {
        frame.setVisible(true);
    }
}
