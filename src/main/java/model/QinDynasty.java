package model;

class QinDynasty extends Civilization {

    public QinDynasty() {
        Super.name("Bejing");
    }

        @Override
    public BlackPowderUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }
}
