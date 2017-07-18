
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class WarriorHuman extends Character {

    int moveNumber;
    
    public WarriorHuman() {
        super(15, CharacterType.WARRIOR, Race.HUMAN);
    }

    @Override
    public void attack(Character victim, Character ally, int moveNumber) {

        this.moveNumber = moveNumber;
        
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " attacked of the sword at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)" + " with damage " + getDamage());

        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " attacked of the sword at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)" + " with damage " + getDamage());
        
        if (isPrivileges() == true) {
            setPrivileges(false);
        }
        if (isIll() == true) {
            makeIll(false);
        }
    }

}
