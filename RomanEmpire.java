public class RomanEmpire{
	private Population pop;
	private Treasury cash;
	private CoalMine mine;
	private River water;
	private Technology tech;
	private Strategy strat;
	private Settlement[] settlements = new Settlement[10];
	private int numOfSettlements = 1;

	public RomanEmpire(){
		pop = new Population();
		cash = new Treasury();
		mine = new CoalMine();
		water = new River("The Tiber");
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

	public boolean buildAquaduct(Settlement whereToBuildAquaduct){
		boolean built = whereToBuildAquaduct.build(cash.getCoins(), pop, 250, 130);
		tech.increaseExperience(10);
		return built;
	}


	public boolean buildBathHouse(Settlement whereToBuildBathHouse){
		boolean built = whereToBuildBathHouse.build(cash.getCoins(), pop, 110, 20);
		tech.increaseExperience(10);
		return built;
	}

	public boolean buildVilla(Settlement whereToBuildVilla){
		boolean built = whereToBuildVilla.build(cash.getCoins(), pop, 80, 15);
		tech.increaseExperience(5);
		return built;
	}

	public void studyPhilosophy(){
		if (pop.getHappiness() >= 10){
			pop.decreaseHappiness(10);
			tech.philosophize();
		}
	}
}