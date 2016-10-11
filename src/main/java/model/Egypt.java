package model;

class Egypt extends Civilization {

    public Egypt() {
        Super.name("Thebes");
    }
    @Override
    public WarChariot getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Pyramid getLandmark(){
        return new Pyramid(this);
    }
}
