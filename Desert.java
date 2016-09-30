import java.util.Scanner;

public class Desert {
    private String name;
    private Scanner scan = new Scanner(System.in);

    public Desert(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int findTreasure() {
        int randomTreasure = (int) Math.ceil(Math.random() * 500);
        boolean getsLost = false;
        if ((int) Math.ceil(Math.random() * 10) == 7) {
            lost();
        }
        return randomTreasure;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}