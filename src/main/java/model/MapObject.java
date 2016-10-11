package model;

abstract class MapObject implements Symbolizable {
    private int health;
    private Civilization owner;

    public MapObject(int health, Civilization owner) {
        this.health = health;
        this.owner = owner;
    }

    public Civilization getOwner() {
        return owner;
    }

    @Override
    public char symbol() {
        char def = 's';
        return def;
    }

    public void damage(int healthAmount) {
        this.health -= healthAmount;
    }

    public boolean isDestroyed() {
        return this.health <= 0;
    }

    public abstract void tick();

    @Override
    public String toString() {
        return "Health: " + health + ", Owner: " + owner.getName() + ".";
    }

}
