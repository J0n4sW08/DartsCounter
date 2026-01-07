import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame frame;
    private JPanel panel;

    public GUI() {
        frame = new JFrame("Darts Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());


        panel.add(new JLabel("Hallo! Gib einen Namen ein um einen Spieler zu erstellen!"), BorderLayout.NORTH);
        panel.add(new JLabel("test"), BorderLayout.NORTH);



        frame.setContentPane(panel);
        frame.setSize(300, 400);


    }

    public void show() {
        frame.setVisible(true);
    }
}
