import java.util.Random;

public class Population {
    private Random rand = new Random();

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }
}