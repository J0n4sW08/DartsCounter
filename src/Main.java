import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int startPunkte = 501;
    boolean addPlayer = false;
    String tempName;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        List<Player> spieler = new ArrayList<>();

        main.beginSetup(scanner, spieler);
    }

    void beginSetup(Scanner scannerObj, List<Player> spielerListe) {
        System.out.println("Hallo! Gib einen Namen ein um einen Spieler zu erstellen!");
        tempName = scannerObj.nextLine();
        spielerListe.add(new Player(tempName, startPunkte));
        System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
        if (scannerObj.nextLine().equalsIgnoreCase("Y")){
            addPlayer = true;
        }
        while(addPlayer){
            System.out.println("Gib noch einen Namen ein!");
            tempName = scannerObj.nextLine();
            spielerListe.add(new Player(tempName, startPunkte));
            System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
            addPlayer = scannerObj.nextLine().equalsIgnoreCase("Y");
        }
    }
}
