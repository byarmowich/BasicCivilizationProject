public class Settlement {
    private String name;
    private Building[] buildings = new Building[10];
    private int numOfBuildings = 0;

    public Settlement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addBuilding(Building newBuilding) {
        if (!buildings[buildings.length - 1].equals(null)) {
            expandSettlement();
        }
        buildings[numOfBuildings] = newBuilding;
        numOfBuildings++;
    }

    public boolean build(int aM, Population pop, int cost, int workersReq) {
        if (aM < cost || pop.getCivilians() < workersReq) {
            return false;
        } else {
            Building newBuilding = new Building(cost, workersReq);
            addBuilding(newBuilding);
            return true;
        }
    }

    public void expandSettlement() {
        Building[] temp = new Building[numOfBuildings * 2];
        for (int i = 0; i < numOfBuildings - 1; i++) {
            temp[i] = buildings[i];
        }
        buildings = temp;
    }
}