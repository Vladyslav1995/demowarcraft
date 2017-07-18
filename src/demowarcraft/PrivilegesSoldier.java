package demowarcraft;

import java.util.ArrayList;

import demowarcraft.races.Character;

public class PrivilegesSoldier {

    private static PrivilegesSoldier Instance;
    private ArrayList<Character> list = null;

    public static PrivilegesSoldier getInstance() {
        if (Instance == null) {
            Instance = new PrivilegesSoldier();
        }
        return Instance;
    }

    private PrivilegesSoldier() {
        list = new ArrayList<>();
    }

    public ArrayList<Character> getArray() {
        return this.list;
    }

    public void addToArray(Character soldier) {
        list.add(soldier);
    }

    public void removeFromArray(Character soldier) {
        list.remove(soldier);
    }
}
