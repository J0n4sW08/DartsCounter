import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
//    void game(Scanner scanner, List<Player> spieler) {
//        beginSetup(scanner, spieler);
//
//        while(noWinner){
//            for (int i = 0; i < spieler.size(); i++) {
//                spieler.get(i).spielZug();
//                if(spieler.get(i).getPoints() == 0) {
//                    noWinner = false;
//                    break;
//                }
//            }
//        }
//    }
//
//    void beginSetup(Scanner scannerObj, List<Player> spielerListe) {
//        System.out.println("Hallo! Gib einen Namen ein um einen Spieler zu erstellen!");
//        tempName = scannerObj.nextLine();
//        spielerListe.add(new Player(tempName, startPunkte, scannerObj));
//        System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
//        if (scannerObj.nextLine().equalsIgnoreCase("Y")){
//            addPlayer = true;
//        }
//        while(addPlayer){
//            System.out.println("Gib noch einen Namen ein!");
//            tempName = scannerObj.nextLine();
//            spielerListe.add(new Player(tempName, startPunkte, scannerObj));
//            System.out.println("Super! Wenn du noch einen Spieler hinzufügen willst drücke Y wenn nicht, N.");
//            addPlayer = scannerObj.nextLine().equalsIgnoreCase("Y");
//        }
//    }
}
