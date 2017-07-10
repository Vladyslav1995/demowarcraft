package demowarcraft.races;

import java.util.Random;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class CrossbowHuman extends Character {

    public CrossbowHuman() {
        super(4, CharacterType.CROSSBOWMAN, Race.HUMAN);
    }

    @Override
    public void attack(Character victim, Character ally) {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            primeAttack(victim);
        } else {
            shotOfTheCrossbown(victim);
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

    private void shotOfTheCrossbown(Character victim) {
        if (isPrivileges()) {
            setDamage((float) (1.5 * 5));
        } else {
            setDamage(5);
        }
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " shoots with the crossbow at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }

}
