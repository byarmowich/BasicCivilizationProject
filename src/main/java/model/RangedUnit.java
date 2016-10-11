package model;

public class RangedUnit extends MilitaryUnit {
    public RangedUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public RangedUnit(Civilization owner, int endurance) {
        super(100, owner, endurance, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof RangedUnit || HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
        super.attack(o);
    }

    @Override
    public char symbol() {
        return 'R';
    }


    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }
}