package model;

public class WarChariot extends RangedUnit {
    public WarChariot(Civilization owner) {
        super(owner, 20);
    }

    @Override
    public char symbol() {
        return 'W';
    }


    @Override
    public String toString() {
        return "War Chariot. " + super.toString();
    }
}