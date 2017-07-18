package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;


public class GoblinOrc extends Character {

    int moveNumber;
    
    public GoblinOrc() {
        super(20, CharacterType.GOBLIN, Race.ORCS);
    }

    @Override
    public void attack(Character victim, Character ally, int moveNumber) {
        this.moveNumber = moveNumber;
        
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " hit of the mace at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
        
        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " hit of the mace at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
        if (isPrivileges() == true) {
            setPrivileges(false);
        }
        if (isIll() == true) {
            makeIll(false);
        }
        
    }
}
