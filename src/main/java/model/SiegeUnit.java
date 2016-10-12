package model;

public class SiegeUnit extends MilitaryUnit {
    public SiegeUnit(Civilization owner) {
        super(200, owner, 5, 10, 14, 5, 10, 60);
    }

    @Override
    public void battle(MapObject o) {
        if (o instanceof Building) {
            o.damage(this.getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'S';
    }

    @Override
    public void attack(MapObject map) {
        getOwner().getStrategy().siege();
        this.battle(map);
        super.setCanAttack(false);
    }


    @Override
    public String toString() {
        return "Siege Unit. " + super.toString();
    }
}