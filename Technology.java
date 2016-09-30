public class Technology {
    private int understanding = 0;
    private boolean foundMeaningOfLife = false;
    private int experienceLevel = 0;
    private boolean builtWonderOfTheWorld = false;

    public void philosophize() {
        understanding = understanding + 25;
        checkMeaningOfLife();
    }

    public void improveWriting() {
        understanding = understanding + 10;
        checkMeaningOfLife();
    }

    private void checkMeaningOfLife() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }

    public void increaseExperience(int expIncrease) {
        experienceLevel = experienceLevel + expIncrease;
        checkWorldWonder();
    }

    private void checkWorldWonder() {
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public boolean hasTechnologyWin() {
        return (foundMeaningOfLife && builtWonderOfTheWorld);
    }
}