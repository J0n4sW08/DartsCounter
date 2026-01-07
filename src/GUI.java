import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel;
    private JButton submitPlayer;
    private JTextField nameInput;
    private JButton starteSpielButton;
    private JLabel playerName;
    private JTextArea playerList;

    public GUI(Main main) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);

        playerList.setText("");

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

    }
}
