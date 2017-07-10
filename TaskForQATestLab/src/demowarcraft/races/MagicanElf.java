
package demowarcraft.races;

import java.util.Random;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class MagicanElf extends Character {
    
    public MagicanElf() {
        super(10, CharacterType.MAGICIAN, Race.ELVES);
    }

    @Override
    public void attack(Character victim, Character ally) {

    	Random random = new Random();
        
    	int result = random.nextInt(2);
        if (result == 0) {
            setUpgrade(ally);
        } else {
            magicAttack(victim);
        }

        if (isPrivileges() == true) {
            setPrivileges(false);
        }
        
        if (isIll() == true) {
            makeIll(false);
        } 
    }

    private void setUpgrade(Character ally) {
        ally.setPrivileges(true);
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth() + "HP)" 
                + " upgraded "
                + "soldier " + ally.getRace() + " " + ally.getSoldierType() + " " + ally.getName() + "(" + ally.getHealth()+ "HP)"  + " and increased him damage " + getDamage() + " for next move" );
    }

    private void magicAttack(Character victim) {
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " attacked with magic at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }

}
