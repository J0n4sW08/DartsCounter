public class Player {
    private String name;
    private int points;

    public Player(String name, int startPoints) {
        this.name = name;
        this.points = startPoints;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
