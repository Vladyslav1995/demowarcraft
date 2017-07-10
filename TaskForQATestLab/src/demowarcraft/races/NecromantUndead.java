
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;
import java.util.Random;


public class NecromantUndead extends Character {

    public NecromantUndead() {
        super(5, CharacterType.NECROMANT, Race.UNDEAD);
    }

    @Override
    public void attack(Character victim, Character ally) {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            primeAttack(victim);
        } else {
            sendDesiese(victim);
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
                + " attacked at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }

    public void sendDesiese(Character victim) {
        victim.makeIll(true);
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " sent Desiese to the "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }

}
