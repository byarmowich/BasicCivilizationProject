
package model;

public class Legion extends MeleeUnit {
    public Legion(Civilization owner) {
        super(owner, 45);
    }
        @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion " + super.toString();
    }
    
        @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }
}