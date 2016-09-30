public class Game {
	private int healthIncrease;

	public Game() {
		healthIncrease = 20;
	}

	public Game(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}

	public int getHealth() {
		return healthIncrease;
	}
}