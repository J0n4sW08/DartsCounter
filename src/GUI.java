import javax.swing.*;

public class GUI {
    public GUI () {
        SwingUtilities.invokeLater(() -> new GUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame fenster = new JFrame("Darts Counter");
        fenster.setSize(300, 400);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
    }
}
