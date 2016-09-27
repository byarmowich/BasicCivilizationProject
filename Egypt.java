public class Egypt{
	private Population pop;
	private Treasury cash;
	private CoalMine mine;
	private River water;
	private Technology tech;
	private Strategy strat;
	private Settlement[] settlements = new Settlement[10];
	private int numOfSettlements = 1;

	public Egypt(){
		pop = new Population();
		cash = new Treasury();
		mine = new CoalMine();
		water = new River("The Nile");
		tech = new Technology();
		strat = new Strategy();
		settlements[0] = new Settlement();
	}

	public boolean settle(Settlement newSettlement){
		if (numOfSettlements > 9){
			return false;
		} else{
			settlements[numOfSettlements++] = newSettlement;
			return true;
		}
	}

	public int getNumOfSettlements(){
		return numOfSettlements;
	}

	public boolean buildPyramid(Settlement whereToBuildPyramid){
		boolean built = whereToBuildPyramid.build(cash.getCoins(), pop, 500, 100);
		tech.increaseExperience(10);
		return built;
	}

	public void practiceHieroglyphics(){
		tech.improveWriting();
		pop.increaseHappiness(10);
	}
}