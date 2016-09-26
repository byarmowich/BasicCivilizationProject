import java.util.Random;

public class Population {
    private Random rand = new Random();
    private int warriors;
    private int civilians;
    private int happiness;

    public Population(){
    	warriors = 50;
    	civilians = 50;
    	happiness = 200;
    }

    public boolean canBattle() {
        if (this.warriors > rand.nextInt(100)) {
            this.warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public void increaseHappiness(int increase){
    	happiness = happiness + increase;
    }

    public void decreaseHappiness(int decrease){
    	happiness = happiness - decrease;
    	if (happiness < 0){
    		happiness = 0;
    	}
    }

    public boolean canWork(int workersNeeded){
    	if (workersNeeded < civilians){
			return false;
		} else {
			civilians = civilians - workersNeeded;
			return true;
		}
    }

    public Game hunt(Hills headinToTheHills){
    	return headinToTheHills.hunt();
    }
    public Fish fish(River headinToTheRiver){
    	return headinToTheRiver.getFish();
    }
    public boolean canCook(Game toCook, CoalMine myCoal){
    	if (myCoal.getCoal() > 4 * myCoal.getBurnCost()){
    		for (int i = 0; i < 4; i++){
    			myCoal.burn();
    		}
    		warriors = warriors + 40;
    		civilians = civilians + 60;
    		return true;
    	} else {
    		return false;
    	}
    }

    public boolean canCook(Fish toCook, CoalMine myCoal){   	
    	if (myCoal.getCoal() > 4 * myCoal.getBurnCost()){
    		for (int i = 0; i < 4; i++){
    			myCoal.burn();
    		}
    		warriors = warriors + 10;
    		civilians = civilians + 15;
    		return true;
    	} else {
    		return false;
    	}
    }
}