package model;

//AnglerUnit.java
//Should return its owner’s version of FishingShack.
//Can only build on WATER tiles.
//Should return the symbol: a

class AnglerUnit extends Unit implements Convertable {

    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'a';
    }

    public Building convert() {
        return getOwner().getFishingShack();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.WATER;
    }

    @Override
    public String toString() {
        return "Angler. " + super.toString();
    }
}
