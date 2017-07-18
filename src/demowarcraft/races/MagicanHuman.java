
package demowarcraft.races;

import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;
import java.util.Random;


public class MagicanHuman extends Character {

    int moveNumber;
    
    public MagicanHuman() {
        super(4, CharacterType.MAGICIAN, Race.HUMAN);
    }

    @Override
    public void attack(Character victim, Character ally, int moveNumber) {
        
        this.moveNumber = moveNumber;
        
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

    private void setUpgrade(Character confederate) {
        confederate.setPrivileges(true);
        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " upgraded "
                + "soldier " + confederate.getRace() + " " + confederate.getSoldierType() + " " + confederate.getName() + "(" + confederate.getHealth()+ "HP)"  + " and increased him damage " + confederate.getDamage() + " for next move" );
        
        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " upgraded "
                + "soldier " + confederate.getRace() + " " + confederate.getSoldierType() + " " + confederate.getName() + "(" + confederate.getHealth()+ "HP)"  + " and increased him damage " + confederate.getDamage() + " for next move" );
    }

    private void magicAttack(Character victim) {
        victim.setHealth(victim.getHealth() - getDamage());
        System.out.println(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " attacked of the magic at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
        
        writeToFile(this.moveNumber + ". Soldier " + getRace() + " " + getSoldierType() + " " + getName() + "(" + getHealth()+ "HP)" 
                + " attacked of the magic at "
                + "soldier " + victim.getRace() + " " + victim.getSoldierType() + " " + victim.getName() + "(" + victim.getHealth()+ "HP)"  + " with damage " + getDamage());
    }
}
