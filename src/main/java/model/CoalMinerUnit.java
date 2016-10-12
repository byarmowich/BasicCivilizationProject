package model;

//CoalMinerUnit.java
//Should return its owner’s version of CoalMine.
//Can only build on HILLS tiles.
//Should return the symbol: c

class CoalMinerUnit extends Unit implements Convertable {
    
    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'c';
    }

    public Building convert(){
        return getOwner().getCoalMine();
    }

    public boolean canConvert(TileType type){
        return type == TileType.HILLS;
    }

    @Override
    public String toString() {
        return "Coal Miner. " + super.toString();
    }
}