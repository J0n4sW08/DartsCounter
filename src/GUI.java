import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI {
    private JPanel root;
    private JPanel welcomeScreen;
    private JPanel gameScene;

    private int tempPoints = 0;

    private JButton spielStartenButton;
    private JButton submitPlayer;

    private JTextField nameInput;

    private JTextArea playerList;
    private JLabel amZug;

    private JLabel spielerLabel;
    private JLabel firstThrow;
    private JLabel secondThrow;
    private JLabel thirdThrow;
    private JLabel punkteLabel;
    private JButton doubleButton;
    private JButton tripleButton;
    private JButton tripleButton1;
    private JButton doubleButton1;
    private JButton doubleButton2;
    private JButton trippleButton;
    private JLabel firstThrowPoints;
    private JLabel secondThrowPoints;
    private JLabel thirdThrowPoints;
    private JTextField pointsDart1_1;
    private JTextField pointsDart2_1;
    private JTextField pointsDart3_1;
    private JTextField pointsDart1_2;
    private JTextField pointsDart2_2;
    private JTextField pointsDart3_2;
    private JTextField pointsDart1_3;
    private JTextField pointsDart2_3;
    private JTextField pointsDart3_3;

    public GUI() {
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
                Game.spieler.add(new Player(nameInput.getText(), 501));
                playerList.append(nameInput.getText() + "\n");

                nameInput.setText("");
                for (int i = 0; i < Game.spieler.size(); i++) {
                    System.out.println(Game.spieler.get(i).getName());
                }
            }
        });

        spielStartenButton.addActionListener(e -> {
            cl.show(root, "gameScene"); // Name aus dem Designer
            gameLoop();
        });
    }

    void gameLoop() {
        int i  = 0;
        tempPoints = 0;
        amZug.setText(Game.spieler.get(i).getName());
        Game.spieler.get(i).activePlayer = true;
        punkteLabel.setText("Punkte: " + Game.spieler.get(i).getPoints());
        Game.spieler.get(i).points -= tempPoints;
    }
}
