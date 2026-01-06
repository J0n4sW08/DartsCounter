import java.util.Scanner;

public class Player {
    private String name;
    private float points;
    private Scanner scanner;

    boolean amZug = false;

    public Player(String name, float startPoints, Scanner scanner) {
        this.name = name;
        this.points = startPoints;
        this.scanner = scanner;
    }

    public float getPoints() {
        return points;
    }

    public void spielZug() {
        amZug = true;
        System.out.println("Okay " + this.name + " Du bist am Zug. Was ist dein erster Wurf? " + points);
        wurf();
        if (points > 0 && amZug){
            System.out.println("Sehr gut nun dein 2 Wurf! " + points);
            wurf();
            if (points > 0 && amZug) {
                System.out.println("Sehr gut nun dein 3 Wurf! " + points);
                wurf();
            }
        }
        if (points == 0){
            System.out.println("Herzlichen Glückwunsch " + name + " Du hast diese Runde gewonnen!!!");

        }

    }

    public void wurf() {
        float tempWurf = scanner.nextFloat();
        if((points - tempWurf) >= 0){
            points -= tempWurf;
        }else if(points -tempWurf < 0){
            System.out.println("Du hast überworfen!");
            amZug = false;
        }
    }
}
