package model;

//SettlerUnit.java
//Should have an instance variable townName of type String, which stores the name of the town these guys want to settle.
//This class’s only constructor should take in a Civilization representing the owner, as well as a String representing the town
//name, and the instance variable should be set appropriately.
//Should return its owner’s version of Settlement.
//Whenever this unit converts, it should increment its owner’s number of settlements.
//Can only build on PLAINS tiles.
//Should return the symbol: s
//This toString should, return something like “Settlers of INSERTTOWNNAMEHERE. “ appended to the beginning of the super class’s
//toString.

class SettlerUnit extends Unit implements Convertable {
    private String townName;

    
    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    @Override
    public char symbol() {
        return 's';
    }

    public Building convert() {
        getOwner().incrementNumSettlements();
        return getOwner().getSettlement(townName);
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public String toString() {
        return "Settlers of " + townName + ". " + super.toString();
    }
}