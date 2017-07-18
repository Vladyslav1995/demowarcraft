
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;
import java.util.Random;

public class ShamanOrc extends Character {

    int moveNumber;
    
    public ShamanOrc() {
        super(0, CharacterType.SHAMAN, Race.ORCS);
    }

    @Override
    public void attack(Character victim, Character ally, int moveNumber) {
        
        this.moveNumber = moveNumber;
        
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            setUpgrade(ally);
        } else {
            makeCursed(victim);
        }

        if (isPrivileges() == true) {
            setPrivileges(false);
        }
        if (isIll() == true) {
            makeIll(false);
        }
    }

    private void setUpgrade(Character confederate) {
        confederate.setPrivileges(true);
        System.out.println(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " upgraded "
                + "soldier " + confederate.getRace() + " " + confederate.getSoldierType() + " " + confederate.getName() + "(" + confederate.getHealth()+ "HP)" + " and increased him damage " + confederate.getDamage() + " for next move.");
        
        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " upgraded "
                + "soldier " + confederate.getRace() + " " + confederate.getSoldierType() + " " + confederate.getName() + "(" + confederate.getHealth()+ "HP)" + " and increased him damage " + confederate.getDamage() + " for next move.");

    }

    public void makeCursed(Character victim) {
        System.out.println(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " make course the "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)" + " and remove all privileges.");
        
        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)"
                + " make course the "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)" + " and remove all privileges.");

        if (victim.isPrivileges()) {
            victim.setPrivileges(false);
        } else {
            System.out.println("But this soldier hasn't any privileges.");
            writeToFile("But this soldier hasn't any privileges.");
        }

    }
}
