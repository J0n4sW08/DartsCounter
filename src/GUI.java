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
    private JButton a0Button;
    private JButton doubleButton;
    private JButton trippleButton;

    private JLabel spielerLabel;
    private JLabel firstThrow;
    private JLabel secondThrow;
    private JLabel thirdThrow;
    private JLabel punkteLabel;
    private JLabel wurf1Points;
    private JLabel wurf2Points;
    private JLabel wurf3Points;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a3Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton ENTERButton;

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

        ActionListener listener = e -> {
            Object src = e.getSource();
            if (src == a1Button) {
                System.out.println("a1 gedrückt");
                tempPoints += 1;
            } else if (src == a2Button) {
                System.out.println("a2 gedrückt");
                tempPoints += 2;
            } else if (src == a3Button) {
                System.out.println("a3 gedrückt");
                tempPoints += 3;
            } else if (src == a4Button) {
                System.out.println("a4 gedrückt");
                tempPoints += 4;
            } else if (src == a5Button) {
                System.out.println("a5 gedrückt");
                tempPoints += 5;
            } else if (src == a6Button) {
                System.out.println("a6 gedrückt");
                tempPoints += 6;
            } else if (src == a7Button) {
                System.out.println("a7 gedrückt");
                tempPoints += 7;
            } else if (src == a8Button) {
                System.out.println("a8 gedrückt");
                tempPoints += 8;
            } else if (src == a9Button) {
                System.out.println("a9 gedrückt");
                tempPoints += 9;
            } else if (src == a0Button) {
                System.out.println("a0 gedrückt");
                tempPoints += 0;
            } else if (src == doubleButton) {
                System.out.println("double gedrückt");
            } else if (src == trippleButton) {
                System.out.println("tripple gedrückt");
            }else if (src == ENTERButton){
                System.out.println("ENTER");
            }
            wurf1Points.setText(wurf1Points.getText() + tempPoints);
        };


        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a0Button.addActionListener(listener);
        doubleButton.addActionListener(listener);
        trippleButton.addActionListener(listener);
        ENTERButton.addActionListener(listener);
    }

    void gameLoop() {
        int i  = 0;
        tempPoints = 0;
        amZug.setText(Game.spieler.get(i).getName());
        Game.spieler.get(i).activePlayer = true;
        punkteLabel.setText("Punkte: " + Game.spieler.get(i).getPoints());
        Game.spieler.get(i).points -= tempPoints;
        punkteLabel.setText("Punkte: " + Game.spieler.get(i).getPoints());


        firstThrow.setBackground(Color.BLUE);

    }
}
