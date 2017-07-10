package demowarcraft.races;

import java.util.Random;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class ArchmenOrc extends Character {

    public ArchmenOrc() {
        super(2, CharacterType.BOWMAN, Race.ORCS);
    }

    @Override
    public void attack(Character victim, Character ally) {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            bladeHit(victim);
        } else {
            archery(victim);
        }
        
        if (isPrivileges() == true) {
            setPrivileges(false);
        }
    
        if (isIll() == true) {
            makeIll(false);
        } 
            
    }

    private void bladeHit(Character victim) {
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " hit of the blade at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());

    }

    private void archery(Character victim) {
        if (isPrivileges()) {
            setDamage((int) (1.5 * 3));
        } else {
            setDamage(3);
        }
        
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName()
                + " archering at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + " with damage " + getDamage());
    }
}
