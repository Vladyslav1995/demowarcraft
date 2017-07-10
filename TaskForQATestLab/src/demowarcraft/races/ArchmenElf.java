package demowarcraft.races;

import java.util.Random;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class ArchmenElf extends Character{
    
    public ArchmenElf() {
        super(3, CharacterType.BOWMAN, Race.ELVES);
    }
    
    @Override
    public void attack(Character victim, Character ally) {
        Random random = new Random();
        int result = random.nextInt(2);
        if(result == 0) {
            primeAttack(victim);
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
    
    private void primeAttack(Character victim) {
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " attacked "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());

    }
    
    private  void archery (Character victim) {
        if (isPrivileges()) {
            setDamage((float) (1.5*7));
        } else {
            setDamage(7);
        }
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " archering at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }

}
