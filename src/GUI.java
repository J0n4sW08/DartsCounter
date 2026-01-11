import javax.swing.*;
import java.awt.*;
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
    private JLabel punkteLabel;

    private JLabel firstThrow;
    private JLabel secondThrow;
    private JLabel thirdThrow;

    private JLabel wurf1Points;
    private JLabel wurf2Points;
    private JLabel wurf3Points;

    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;

    private JButton doubleButton;
    private JButton trippleButton;
    private JButton ENTERButton;
    private JButton nextPlayerButton; // Neuer Button für Spielerwechsel
    private JPanel winnerScreen;
    private JLabel winnerText;

    private final StringBuilder input = new StringBuilder();
    private int currentPlayerIndex = 0;
    private int currentThrow = 1; // Zähler für den aktuellen Wurf

    public GUI() {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

        playerList.setEditable(false);

        initWelcomeScreen();
        initGameScreen();
    }

    /* -------------------- Welcome Screen -------------------- */

    private void initWelcomeScreen() {
        submitPlayer.addActionListener(e -> addPlayer());

        spielStartenButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) root.getLayout();
            cl.show(root, "gameScene");
            startRound();
        });
    }

    private void addPlayer() {
        String name = nameInput.getText().trim();
        if (name.isEmpty()) return;

        Game.spieler.add(new Player(name, 501));
        playerList.append(name + "\n");
        nameInput.setText("");
    }

    /* -------------------- Game Screen -------------------- */

    private void initGameScreen() {
        setupNumberButtons();
        doubleButton.addActionListener(e -> applyMultiplier(2));
        trippleButton.addActionListener(e -> applyMultiplier(3));
        ENTERButton.addActionListener(e -> submitThrow());
        nextPlayerButton.addActionListener(e -> nextPlayer()); // Listener für neuen Button
    }

    private void setupNumberButtons() {
        ActionListener numberListener = e -> {
            String digit = e.getActionCommand();
            input.append(digit);
            updateInputLabel(currentThrow, input.toString());
        };


        setupNumberButton(a0Button, "0", numberListener);
        setupNumberButton(a1Button, "1", numberListener);
        setupNumberButton(a2Button, "2", numberListener);
        setupNumberButton(a3Button, "3", numberListener);
        setupNumberButton(a4Button, "4", numberListener);
        setupNumberButton(a5Button, "5", numberListener);
        setupNumberButton(a6Button, "6", numberListener);
        setupNumberButton(a7Button, "7", numberListener);
        setupNumberButton(a8Button, "8", numberListener);
        setupNumberButton(a9Button, "9", numberListener);
    }

    private void setupNumberButton(JButton button, String value, ActionListener listener) {
        button.setActionCommand(value);
        button.addActionListener(listener);
    }

    /* -------------------- Game Logic -------------------- */

    private void startRound() {
        currentPlayerIndex = 0;
        currentThrow = 1;
        updateActivePlayer();
    }

    private void updateActivePlayer() {
        Player player = Game.spieler.get(currentPlayerIndex);
        amZug.setText(player.getName());
        punkteLabel.setText("Punkte: " + player.getPoints());

        clearInput();
        highlightThrow(currentThrow);

    }

    private void submitThrow() {
        if (input.length() == 0) return;

        int points = Integer.parseInt(input.toString());
        Player player = Game.spieler.get(currentPlayerIndex);

        player.addPoints(-points);
        punkteLabel.setText("Punkte: " + player.getPoints());

        updateThrowLabel(currentThrow, points);
        if(player.getPoints() <= 0) {
            System.out.println("du hast gewonnen");
            CardLayout cl = (CardLayout) root.getLayout();
            cl.show(root, "winnerScreen");
            winnerText.setText(player.getName() + " hat das Spiel gewonnen!!!");
        }


        if (currentThrow < 3) {
            currentThrow++;
            highlightThrow(currentThrow);
        } else {
            currentThrow = 1;
            nextPlayer();
        }
        clearInput();
    }

    private void applyMultiplier(int factor) {
        if (input.length() == 0) return;

        int value = Integer.parseInt(input.toString()) * factor;
        input.setLength(0);
        input.append(value);
        wurf1Points.setText(input.toString());
    }

    private void clearInput() {
        input.setLength(0);
        updateInputLabel(currentThrow, ""); // Nur aktuelles Label löschen
    }


    private void highlightThrow(int throwNumber) {
        firstThrow.setOpaque(false);
        secondThrow.setOpaque(false);
        thirdThrow.setOpaque(false);

        firstThrow.setBackground(null);
        secondThrow.setBackground(null);
        thirdThrow.setBackground(null);

        switch (throwNumber) {
            case 1 -> {
                firstThrow.setOpaque(true);
                firstThrow.setBackground(Color.BLUE);
            }
            case 2 -> {
                secondThrow.setOpaque(true);
                secondThrow.setBackground(Color.BLUE);
            }
            case 3 -> {
                thirdThrow.setOpaque(true);
                thirdThrow.setBackground(Color.BLUE);
            }
        }
    }

    private void updateThrowLabel(int throwNumber, int points) {
        switch (throwNumber) {
            case 1 -> wurf1Points.setText(String.valueOf(points));
            case 2 -> wurf2Points.setText(String.valueOf(points));
            case 3 -> wurf3Points.setText(String.valueOf(points));
        }
    }

    private void clearThrowPoints() {
        wurf1Points.setText("");
        wurf2Points.setText("");
        wurf3Points.setText("");
    }

    private void nextPlayer() {
        clearInput();
        clearThrowPoints();

        currentPlayerIndex++;
        if (currentPlayerIndex >= Game.spieler.size()) {
            currentPlayerIndex = 0;
        }
        currentThrow = 1;
        updateActivePlayer();
    }
    private void updateInputLabel(int throwNumber, String text) {
        switch (throwNumber) {
            case 1 -> wurf1Points.setText(text);
            case 2 -> wurf2Points.setText(text);
            case 3 -> wurf3Points.setText(text);
        }
    }

}
