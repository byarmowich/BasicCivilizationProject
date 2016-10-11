package model;

class RomanEmpire extends Civilization {
    public RomanEmpire() {
        Super.name("Rome");
    }

    @Override
    public Legion getMeleeUnit() {
        return new Legion(this);
    }
        @Override
    public Coliseum getLandmark(){
        return new Coliseum(this);
    }
}
