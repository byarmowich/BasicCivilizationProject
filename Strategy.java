public class Strategy{
	private int strategyLevel = 0;
	private final int BATTLE_INCREASE = 10;
	private final int SIEGE_INCREASE = 40;
	private boolean conquerTheWorld = false;

	public void battle(){
		strategyLevel = strategyLevel + BATTLE_INCREASE;
		checkStrategyVictory();
	}

	public void siege(){
		strategyLevel = strategyLevel + SIEGE_INCREASE;
		checkStrategyVictory();
	}

	private void checkStrategyVictory(){
		if (strategyLevel > 180){
			conquerTheWorld = true;
		}
	}

	public boolean hasStrategyWin(){
		if (conquerTheWorld){
			return true;
		} else{
			return false;
		}
	}

}