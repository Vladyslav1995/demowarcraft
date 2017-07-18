package demowarcraft;


import java.util.ArrayList;
import java.util.Random;

import demowarcraft.races.Character;

/*
 * @author Vladyslav Shynal
 * 
 * The class RunGame is engine for start of game when two enemy  detachment are fighting one against another.
 * 
 */

public class RunGame {

    public static byte activeRaces;
    public static int moveNumber = 1;

    public static void main(String[] args){

        CreatePlayers createPlayers = new CreatePlayers();

        ArrayList<Character> firstRace = new ArrayList();
        ArrayList<Character> secondRace = new ArrayList();

        Random random = new Random();
        int indexFirstRace = random.nextInt(4); // choose from 1 to 4
        int indexSecondRace;

        String firstRaceName = null;
        String secondRaceName = null;

        //0 - elves
        //1 - human
        //2 - orcs
        //3 - undead
        System.out.println("**************************************** Game start`s!!! ****************************************");

        switch (indexFirstRace) {

            case 0:
                firstRace.addAll(createPlayers.createElves());
                indexSecondRace = random.nextInt(2);
                //Elves vs Orcs or Undead
                if (indexSecondRace == 0) {
                    secondRace.addAll(createPlayers.createOrcs());
                    firstRaceName = "Elves";
                    secondRaceName = "Orcs";
                    System.out.println("The race of Elves is going to fight with the race of Orcs.");
                     }
             else{  	
                    secondRace.addAll(createPlayers.createUndead());
                    firstRaceName = "Elves";
                    secondRaceName = "Undead";
                    System.out.println("The race of Elves is going to fight with the race of Undead.");
                     }
                break;

            case 1:
                firstRace.addAll(createPlayers.createHumans());
                indexSecondRace = random.nextInt(2);
                //Human vs Orcs or Undead
                if (indexSecondRace == 0) {
                    secondRace.addAll(createPlayers.createOrcs());
                    firstRaceName = "Human";
                    secondRaceName = "Orcs";
                    System.out.println("The race of Human is going to fight with the race of Orcs.");
                } else {
                    secondRace.addAll(createPlayers.createUndead());
                    firstRaceName = "Human";
                    secondRaceName = "Undead";
                    System.out.println("The race of Human is going to fight with the race of Undead.");
                }
                break;

            case 2:
                firstRace.addAll(createPlayers.createOrcs());
                indexSecondRace = random.nextInt(2);
                //Orcs vs Human or Elves
                if (indexSecondRace == 0) {
                    secondRace.addAll(createPlayers.createHumans());
                    firstRaceName = "Orcs";
                    secondRaceName = "Human";
                    System.out.println("The race of Orcs is going to fight with the race of  Humans.");
                } else {
                    secondRace.addAll(createPlayers.createElves());
                    firstRaceName = "Orcs";
                    secondRaceName = "Elves";
                    System.out.println("The race of Orcs is going to fight with the race of Elves.");
                }
                break;

            case 3:
                firstRace.addAll(createPlayers.createUndead());
                indexSecondRace = random.nextInt(2);
                //Undead vs Elves or Human
                if (indexSecondRace == 0) {
                    secondRace.addAll(createPlayers.createElves());
                    firstRaceName = "Undead";
                    secondRaceName = "Elves";
                    System.out.println("The race of Undead is going to fight with the race of Elves.");
                } else {
                    secondRace.addAll(createPlayers.createHumans());
                    firstRaceName = "Undead";
                    secondRaceName = "Human";
                    System.out.println("The race of Undead is going to fight with the race of Humans.");
                }
                break;
        }

        int firstMove = random.nextInt(2);// choose from 0 to 1 
        if (firstMove == 0) {
            System.out.println("The first move for " + firstRaceName + "!");
            activeRaces = 0;
        } else {
            System.out.println("The first move for " + secondRaceName + "!");
            activeRaces = 1;
        }

        PrivilegesSoldier privilegesSoldiers = PrivilegesSoldier.getInstance();
        ArrayList<Character> allPrivilegesSoldier = privilegesSoldiers.getArray();
        ArrayList<Character> privilegesFirstRace = new ArrayList<>();
        ArrayList<Character> privilegesSecondRace = new ArrayList<>();

        while ((!firstRace.isEmpty() || !privilegesFirstRace.isEmpty()) || (!secondRace.isEmpty() || !privilegesSecondRace.isEmpty())) {
            //getting soldierList with privileges
            for (Character soldier : allPrivilegesSoldier) {
                if (soldier.isPrivileges() && firstRace.get(0).getRace().equals(soldier.getRace())) {
                    privilegesFirstRace.add(soldier);
                }
            }

            for (Character soldier : allPrivilegesSoldier) {
                if (soldier.isPrivileges() && secondRace.get(0).getRace().equals(soldier.getRace())) {
                    privilegesSecondRace.add(soldier);
                }
            }

            //firstRace moving
            if (activeRaces == 0) {
                if (firstRace.isEmpty()) {
                    break;
                }
                //if privileges group isn't empty, select attacker from privileges group
                if (!privilegesFirstRace.isEmpty()) {

                    //random generating attacker and victim
                    int indexAttacker = random.nextInt(privilegesFirstRace.size());
                    int indexVictim = random.nextInt(secondRace.size());
                    int indexConfederate = random.nextInt(firstRace.size());

                    //attacking victim
                    privilegesFirstRace.get(indexAttacker).attack(secondRace.get(indexVictim), firstRace.get(indexConfederate), moveNumber);
                    moveNumber++;

                    //check, if victim is alive
                    if (secondRace.get(indexVictim).getHealth() <= 0) {
                        System.out.println("Soldier " + secondRace.get(indexVictim).getRace() + " " + secondRace.get(indexVictim).getSoldierType() + " " + secondRace.get(indexVictim).getName() + " died"); 
                        secondRace.remove(indexVictim);
                    }

                } else {
                    //if privileges group is empty, selecting attacker from prime group
                    //random generating attacker and victim
                    int indexAttacker = random.nextInt(firstRace.size());
                    int indexVictim = random.nextInt(secondRace.size());
                    int indexConfederate = random.nextInt(firstRace.size());

                    //attacking victim
                    firstRace.get(indexAttacker).attack(secondRace.get(indexVictim), firstRace.get(indexConfederate), moveNumber);
                    moveNumber++;

                    //check, if victim is alive
                    if (secondRace.get(indexVictim).getHealth() <= 0) {
                        System.out.println("Soldier " + secondRace.get(indexVictim).getRace() + " " + secondRace.get(indexVictim).getSoldierType() + " " + secondRace.get(indexVictim).getName() + " died"); 
                        secondRace.remove(indexVictim);
                    }

                }
                activeRaces = 1;

            } else {
                //SecondRace moving
                if (secondRace.isEmpty()) {
                    break;
                }
                //if privileges group isn't empty, selecting attacker from privileges group
                if (!privilegesSecondRace.isEmpty()) {

                    //random generating attacker and victim
                    int indexAttacker = random.nextInt(privilegesSecondRace.size());
                    int indexVictim = random.nextInt(firstRace.size());
                    int indexConfederate = random.nextInt(secondRace.size());

                    //attacking victim
                    privilegesSecondRace.get(indexAttacker).attack(firstRace.get(indexVictim), secondRace.get(indexConfederate), moveNumber);
                    moveNumber++;

                    //check, if victim is alive
                    if (firstRace.get(indexVictim).getHealth() <= 0) {
                        System.out.println("Soldier " + firstRace.get(indexVictim).getRace() + " " + firstRace.get(indexVictim).getSoldierType() + " " + firstRace.get(indexVictim).getName() + " died");
                        firstRace.remove(indexVictim);
                    }

                } else {
                    //if privileges group is empty, selecting attacker from prime group
                    //random generating attacker and victim
                    int indexAttacker = random.nextInt(secondRace.size());
                    int indexVictim = random.nextInt(firstRace.size());
                    int indexConfederate = random.nextInt(secondRace.size());

                    //attacking victim
                    secondRace.get(indexAttacker).attack(firstRace.get(indexVictim), secondRace.get(indexConfederate), moveNumber);
                    moveNumber++;

                    //check, if victim is alive
                    if (firstRace.get(indexVictim).getHealth() <= 0) {
                        System.out.println("Soldier " + firstRace.get(indexVictim).getRace() + " " + firstRace.get(indexVictim).getSoldierType() + " " + firstRace.get(indexVictim).getName() + " died");
                        firstRace.remove(indexVictim);
                    }
                }
                activeRaces = 0;
            }
        }

        System.out.println("The race of " + firstRaceName + " left with " + firstRace.size() + " soldiers");
        System.out.println("The race of " + secondRaceName + " left with " + secondRace.size() + " soldiers");
    
        if (firstRace.size() > 0) {
            System.out.println("Race of " + firstRaceName + " won.");
        }
        if (secondRace.size() > 0) {
            System.out.println("Race of " + secondRaceName + " won.");
        }
        if (firstRace.size() == secondRace.size()) {
            System.out.println("The game ended in a draw.");
         }
    }
  }

