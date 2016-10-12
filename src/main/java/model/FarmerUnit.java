package model;

//FarmerUnit.java
//Should return its owner’s version of Farm.
//Can only build on PLAINS tiles.
//Should return the symbol: f

class FarmerUnit extends Unit implements Convertable {
    
    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'f';
    }

    public Building convert(){
        return getOwner().getFarm();
    }

    public boolean canConvert(TileType type){
        return type == TileType.PLAINS;
    }

    @Override
    public String toString() {
        return "Farmer. " + super.toString();
    }
}