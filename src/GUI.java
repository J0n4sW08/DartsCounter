import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel root;
    private JPanel welcomeScreen;
    private JPanel gameScene;

    private JButton spielStartenButton;
    private JButton submitPlayer;

    private JTextField nameInput;

    private JTextArea playerList;
    private JLabel amZug;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton doubleButton;
    private JButton trippleButton;

    private JLabel spielerLabel;
    private JLabel firstThrow;
    private JLabel secondThrow;
    private JLabel thirdThrow;
    private JLabel punkteLabel;

    public GUI(Main main) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);
        playerList.setEditable(false);
        playerList.setText("");

        CardLayout cl = (CardLayout) root.getLayout();

        submitPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.spieler.add(new Player(nameInput.getText(), 501));
                playerList.append(nameInput.getText() + "\n");

                nameInput.setText("");
                for (int i = 0; i < main.spieler.size(); i++) {
                    System.out.println(main.spieler.get(i).getName());
                }
            }
        });

        spielStartenButton.addActionListener(e -> {
            cl.show(root, "gameScene"); // Name aus dem Designer
        });

    }

    void game() {

    }
}
