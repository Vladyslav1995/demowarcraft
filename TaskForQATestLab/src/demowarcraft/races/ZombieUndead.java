
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class ZombieUndead extends Character {

    public ZombieUndead() {
        super(18, CharacterType.ZOMBIE, Race.UNDEAD);
    }

    @Override
    public void attack(Character victim, Character ally) {

        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " hit the spear in "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)" + " with damage " + getDamage());
        
        
        if (isPrivileges() == true) {
            setPrivileges(false);
        }
        if (isIll() == true) {
            makeIll(false);
        }

    }
}
