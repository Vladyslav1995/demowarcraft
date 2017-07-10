
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;

public class WarriorHuman extends Character {

    public WarriorHuman() {
        super(15, CharacterType.WARRIOR, Race.HUMAN);
    }

    @Override
    public void attack(Character victim, Character ally) {

        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
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
