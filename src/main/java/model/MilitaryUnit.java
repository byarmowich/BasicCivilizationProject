package model;

abstract class MilitaryUnit extends Unit {
    private int damage;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance, int pay, int initialGoldCost, int initialFoodCost, int initialResourceCost, int damage){
        super(health, owner, baseEndurance, pay, initialGoldCost, initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }
        @Override
    public void tick() {
        super.tick();
        super.setCanAttack(true);
    }

    public int getDamage() {
    	return damage;
    }

    public abstract void battle(MapObject map);

    public void attack(MapObject map) {
        getOwner().getStrategy().battle();
        this.battle(map);
        super.setCanAttack(false);
    }
        @Override
    public String toString() {
        return "Military Unit: " + super.toString();
    }
}
