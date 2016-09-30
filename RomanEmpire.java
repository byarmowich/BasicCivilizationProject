public class RomanEmpire {
	private Population pop;
	private Treasury cash;
	private CoalMine mine;
	private River water;
	private Technology tech;
	private Strategy strat;
	private Hills hill;
	private Settlement[] settlements = new Settlement[10];
	private int numOfSettlements = 1;

	public RomanEmpire() {
		pop = new Population();
		cash = new Treasury();
		mine = new CoalMine();
		water = new River("Tiber");
		tech = new Technology();
		strat = new Strategy();
		hill = new Hills();
		settlements[0] = new Settlement("Rome");
	}

	public Population getPopulation() {
		return pop;
	}

	public Treasury getTreasury() {
		return cash;
	}

	public CoalMine getCoalMine() {
		return mine;
	}

	public River getRiver() {
		return water;
	}

	public Technology getTechnology() {
		return tech;
	}

	public Strategy getStrategy() {
		return strat;
	}

	public Hills getHills() {
		return hill;
	}

	public Settlement[] getSettlements() {
		return settlements;
	}

	public boolean settle(Settlement newSettlement) {
		if (numOfSettlements > 9) {
			return false;
		} else {
			settlements[numOfSettlements++] = newSettlement;
			return true;
		}
	}

	public int getNumSettlements() {
		return numOfSettlements;
	}

	public boolean buildAqueduct(Settlement whereToBuildAquaduct) {
		boolean built;
		built = whereToBuildAquaduct.build(cash.getCoins(), pop, 250, 130);
		tech.increaseExperience(10);
		return built;
	}


	public boolean buildBathHouse(Settlement whereToBuildBathHouse) {
		boolean built;
		built = whereToBuildBathHouse.build(cash.getCoins(), pop, 110, 20);
		tech.increaseExperience(10);
		return built;
	}

	public boolean buildVilla(Settlement whereToBuildVilla) {
		boolean built;
		built = whereToBuildVilla.build(cash.getCoins(), pop, 80, 15);
		tech.increaseExperience(5);
		return built;
	}

	public void studyPhilosophy() {
		if (pop.getHappiness() >= 10) {
			pop.decreaseHappiness(10);
			tech.philosophize();
		}
	}
}