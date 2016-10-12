package model;

class QinDynasty extends Civilization {

    public QinDynasty() {
        super("Bejing");
    }

    @Override
    public BlackPowderUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }
    @Override
    public GreatWall getLandmark() {
        return new GreatWall(this);
    }
}
