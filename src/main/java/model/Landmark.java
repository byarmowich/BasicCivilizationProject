package model;

public class Landmark extends Building {
    
    public Landmark(Civilization owner) {
        super(200, owner, 0, 0, 0, 10, 0, 10);
    }

    public char symbol() {
         return '!';
    }

    public void invest() {
        setTechPointGeneration(getTechPointGeneration() + 5);
    }

    public String toString() {
        return "Landmark. " + super.toString();
    }
}