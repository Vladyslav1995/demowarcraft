
package demowarcraft;

import java.util.ArrayList;

import demowarcraft.races.ArchmenElf;
import demowarcraft.races.ArchmenOrc;
import demowarcraft.races.CrossbowHuman;
import demowarcraft.races.GoblinOrc;
import demowarcraft.races.HunterUndead;
import demowarcraft.races.MagicanElf;
import demowarcraft.races.MagicanHuman;
import demowarcraft.races.NecromantUndead;
import demowarcraft.races.ShamanOrc;
import demowarcraft.races.Character;
import demowarcraft.races.WarriorElf;
import demowarcraft.races.WarriorHuman;
import demowarcraft.races.ZombieUndead;

/*
 * @author Vladyslav Shynal
 * 
 * The class CreatePlayers is class that just creates instances of soldiers and add`s them to list of their races.
 * 
 */

public class CreatePlayers {

    public ArrayList<Character> createElves() {
        MagicanElf magicanElf = new MagicanElf();
        ArchmenElf archmenElf1 = new ArchmenElf();
        ArchmenElf archmenElf2 = new ArchmenElf();
        ArchmenElf archmenElf3 = new ArchmenElf();
        WarriorElf warriorElf1 = new WarriorElf();
        WarriorElf warriorElf2 = new WarriorElf();
        WarriorElf warriorElf3 = new WarriorElf();
        WarriorElf warriorElf4 = new WarriorElf();

        ArrayList<Character> list = new ArrayList();
        list.add(magicanElf);
        list.add(archmenElf1);
        list.add(archmenElf2);
        list.add(archmenElf3);
        list.add(warriorElf1);
        list.add(warriorElf2);
        list.add(warriorElf3);
        list.add(warriorElf4);

        return list;
    }

    public ArrayList<Character> createHumans() {

        MagicanHuman magicanHuman = new MagicanHuman();
        CrossbowHuman crossbowHuman1 = new CrossbowHuman();
        CrossbowHuman crossbowHuman2 = new CrossbowHuman();
        CrossbowHuman crossbowHuman3 = new CrossbowHuman();
        WarriorHuman warriorHuman1 = new WarriorHuman();
        WarriorHuman warriorHuman2 = new WarriorHuman();
        WarriorHuman warriorHuman3 = new WarriorHuman();
        WarriorHuman warriorHuman4 = new WarriorHuman();

        ArrayList<Character> list = new ArrayList();
        list.add(magicanHuman);
        list.add(crossbowHuman1);
        list.add(crossbowHuman2);
        list.add(crossbowHuman3);
        list.add(warriorHuman1);
        list.add(warriorHuman2);
        list.add(warriorHuman3);
        list.add(warriorHuman4);

        return list;
    }

    public ArrayList<Character> createOrcs() {

        ShamanOrc shamanOrc = new ShamanOrc();
        ArchmenOrc archmenOrc1 = new ArchmenOrc();
        ArchmenOrc archmenOrc2 = new ArchmenOrc();
        ArchmenOrc archmenOrc3 = new ArchmenOrc();
        GoblinOrc goblinOrc1 = new GoblinOrc();
        GoblinOrc goblinOrc2 = new GoblinOrc();
        GoblinOrc goblinOrc3 = new GoblinOrc();
        GoblinOrc goblinOrc4 = new GoblinOrc();

        ArrayList<Character> list = new ArrayList();
        list.add(shamanOrc);
        list.add(archmenOrc1);
        list.add(archmenOrc2);
        list.add(archmenOrc3);
        list.add(goblinOrc1);
        list.add(goblinOrc2);
        list.add(goblinOrc3);
        list.add(goblinOrc4);

        return list;
    }
    
        public ArrayList<Character> createUndead() {

        NecromantUndead necromantUndead = new NecromantUndead();
        HunterUndead hunterUndead1 = new HunterUndead();
        HunterUndead hunterUndead2 = new HunterUndead();
        HunterUndead hunterUndead3 = new HunterUndead();
        ZombieUndead zombieUndead1 = new ZombieUndead();
        ZombieUndead zombieUndead2 = new ZombieUndead();
        ZombieUndead zombieUndead3 = new ZombieUndead();
        ZombieUndead zombieUndead4 = new ZombieUndead();

        ArrayList<Character> list = new ArrayList();
        list.add(necromantUndead);
        list.add(hunterUndead1);
        list.add(hunterUndead2);
        list.add(hunterUndead3);
        list.add(zombieUndead1);
        list.add(zombieUndead2);
        list.add(zombieUndead3);
        list.add(zombieUndead4);

        return list;
    }
}
