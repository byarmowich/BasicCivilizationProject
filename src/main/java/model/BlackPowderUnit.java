package model;

public class BlackPowderUnit extends RangedUnit {
    public BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public void battle(MapObject o) {
            o.damage(this.getDamage());
            super.attack(o);
    }

    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
}