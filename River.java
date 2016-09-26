import java.lang.Math;
public class River{
	private String name;
	private Fish schoolOfFish [] = new Fish[5];
	private int numOfFish;

	public River(String name){
		this.name = name;
		fillRiver();
	}

	public Fish getFish(){
		if (numOfFish == 0) {
			return null;
		} else{
			numOfFish--;
			return schoolOfFish[numOfFish];
		}
	}

	public boolean replenishFish(){
		if (numOfFish != 0){
			return false;
		} else {
			fillRiver();
			return true;
		}
	}

	private void fillRiver(){
		int i = 0;
		while (i < 5){
			schoolOfFish[i] = new Fish((int)Math.ceil(Math.random() * 4));
			i++;
		}
		numOfFish = 5;
	}
}