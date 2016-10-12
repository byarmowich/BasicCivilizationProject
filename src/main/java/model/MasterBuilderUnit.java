package model;

//MasterBuilderUnit.java
//Should return its owner’s version of Landmark.
//Can only build on PLAINS tiles.
//Should return the symbol: m

class MasterBuilderUnit extends Unit implements Convertable {
    
    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'm';
    }

    public Building convert(){
        return getOwner().getLandmark();
    }

    public boolean canConvert(TileType type){
        return type == TileType.PLAINS;
    }

    @Override
    public String toString() {
        return "Master Builder. " + super.toString();
    }
}