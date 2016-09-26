public class Treasury{
	private int gold = 200;

	public int getCoins(){
		return gold;
	}

	public boolean spend(int spending){
		if (spending > gold){
			return false
		} else {
			gold = gold - spending;
			return true;
		}
	}

	public void earn(int earned){
		gold = gold + earned;
	}
}