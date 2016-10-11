package model;
public class GreatWall extends Landmark {
    
    public GreatWall(Civilization owner){
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getStrategy().battle();
    }
}