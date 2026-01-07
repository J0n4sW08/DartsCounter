import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int startPunkte = 501;
    boolean addPlayer = false;
    boolean noWinner = true;
    String tempName;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        List<Player> spieler = new ArrayList<>();

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.show();
        });



        //main.game(scanner, spieler);
    }

    void game(Scanner scanner, List<Player> spieler) {
        beginSetup(scanner, spieler);

        while(noWinner){
            for (int i = 0; i < spieler.size(); i++) {
                spieler.get(i).spielZug();
                if(spieler.get(i).getPoints() == 0) {
                    noWinner = false;
                    break;
                }
            }
        }
    }

    void beginSetup(Scanner scannerObj, List<Player> spielerListe) {
        System.out.println("Hallo! Gib einen Namen ein um einen Spieler zu erstellen!");
        tempName = scannerObj.nextLine();
        spielerListe.add(new Player(tempName, startPunkte, scannerObj));
        System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
        if (scannerObj.nextLine().equalsIgnoreCase("Y")){
            addPlayer = true;
        }
        while(addPlayer){
            System.out.println("Gib noch einen Namen ein!");
            tempName = scannerObj.nextLine();
            spielerListe.add(new Player(tempName, startPunkte, scannerObj));
            System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
            addPlayer = scannerObj.nextLine().equalsIgnoreCase("Y");
        }
    }
}
