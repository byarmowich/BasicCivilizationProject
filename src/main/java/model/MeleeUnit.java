package model;

public class MeleeUnit extends MilitaryUnit {
    public MeleeUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public MeleeUnit(Civilization owner, int damage) {
        super(100, owner, 10, 10, 14, 5, 0, damage);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit || HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
        super.attack(o);
    }

    @Override
    public char symbol() {
        return 'M';
    }


    @Override
    public String toString() {
        return "Melee Unit. " + super.toString();
    }
}