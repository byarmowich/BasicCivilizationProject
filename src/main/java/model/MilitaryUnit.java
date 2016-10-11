package model;
abstract class MilitaryUnits extends Unit {
    private int damage;

    public MilitaryUnits(int health, Civilization owner, int baseEndurance, int pay, int initialGoldCost, int initialFoodCost, int initialResourceCost, int damage){
        super(health, owner, baseEndurance, pay, initialGoldCost, initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }
        @Override
    public void tick() {
        super.tick();
        super.setCanAttack(true);
    }

    public abstract void battle(MapObject map);

    public void attack(MapObject map) {
        Strategy.battle();
        this.battle(map);
        super.setCanAttack(false);
    }
        @Override
    public String toString() {
        return "Military Unit: " + super.toString();
    }
}
