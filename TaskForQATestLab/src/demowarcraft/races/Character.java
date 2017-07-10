package demowarcraft.races;

import demowarcraft.PrivilegesSoldier;
import demowarcraft.races.enums.Race;
import demowarcraft.races.enums.CharacterType;
import java.util.HashSet;
import java.util.Set;

/*
 * @author Vladyslav Shynal
 * 
 * The class Character is prototype of soldier for childish classes that include properties and behavior of different kinds of soldiers that are in common.  
 * 
 */

public class Character {

    private String name = null;

    private float health;

    private boolean havePrivileges = false;

    private boolean isIll = false;

    private float damage;

    private CharacterType soldierType = null;

    private Race race = null;
    
    private PrivilegesSoldier privilegesSoldier = null;

    Character(float damage, CharacterType soldierType, Race race) {

        this.name = randomIdentifier();
        this.health = 100;
        this.damage = damage;
        this.soldierType = soldierType;
        this.race = race;
        privilegesSoldier = PrivilegesSoldier.getInstance();
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public boolean isPrivileges() {
        return havePrivileges;
    }

    public void setPrivileges(boolean havePrivileges) {

        if (havePrivileges == true && this.havePrivileges == false) {
            this.damage = (float) (damage * 1.5);
            privilegesSoldier.addToArray(this);
        }

        if (havePrivileges == false && this.havePrivileges == true) {
            this.damage = (float) (damage / 1.5);
            privilegesSoldier.removeFromArray(this);
        }

        this.havePrivileges = havePrivileges;
    }

    public boolean isIll() {
        return isIll;
    }

    public void makeIll(boolean isIll) {

        if (isIll == true && this.isIll == false) {
            this.damage = (float) (damage / 2);
        }

        if (isIll == false && this.isIll == true) {
            this.damage = (float) (damage * 2);
        }

        this.isIll = isIll;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public CharacterType getSoldierType() {
        return soldierType;
    }

    public void setSoldierType(CharacterType soldierType) {
        this.soldierType = soldierType;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void attack(Character victim, Character confederate) {
//
//        soldier.setHealth(soldier.getHealth() - getDamage());
//        System.out.println("Soldier " + getRace() + " " + getSoldierType() + " " + getName()
//                + " attacked "
//                + "soldier " + soldier.getRace() + " " + soldier.getSoldierType() + " " + soldier.getName() + " with damage " + getDamage());
//        if (isPrivileges() == true) {
//            setPrivileges(false);
//        }
//        if (isCursed() == true) {
//            makeCurse(false);
//        }

    }

    public void show() {

        System.out.println("Military taken:"); 
        System.out.println("Name: " + getName());
        System.out.println("Race: " + getRace());
        System.out.println("SoldierType: " + getSoldierType());
        System.out.println("Health: " + getHealth());
        System.out.println("havePrivileges: " + isPrivileges());
        System.out.println("isIll: " + isIll());
        System.out.println("damage: " + getDamage());
        System.out.println("-------------------------------\n");

    }

    private final String randomIdentifier() {
    	//Method randomIdentifier is generating identifier for each soldier.
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();

        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

}
