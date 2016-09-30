public class QinDynasty {
    private Population pop;
    private Treasury cash;
    private CoalMine mine;
    private River water;
    private Technology tech;
    private Strategy strat;
    private Hills hill;
    private Settlement[] settlements = new Settlement[10];
    private int numOfSettlements = 1;

    public QinDynasty() {
        pop = new Population();
        cash = new Treasury();
        mine = new CoalMine();
        water = new River("Yangztee");
        tech = new Technology();
        strat = new Strategy();
        hill = new Hills();
        settlements[0] = new Settlement("Bejing");
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

    public boolean buildWall(Settlement whereToBuildWall) {
        boolean built;
        built = whereToBuildWall.build(cash.getCoins(), pop, 1000, 100);
        tech.increaseExperience(10);
        return built;
    }


    public boolean buildHouse(Settlement whereToBuildHouse) {
        boolean built;
        built = whereToBuildHouse.build(cash.getCoins(), pop, 30, 8);
        tech.increaseExperience(10);
        return built;
    }

    public void establishLegalism() {
        if (pop.getHappiness() >= 20) {
            pop.decreaseHappiness(20);
            tech.philosophize();
        }
    }
}