package ro.dmoca.Hero;

import ro.dmoca.FileWork.Flux;
import ro.dmoca.Hero.Inventory.Inventory;
import ro.dmoca.Hero.Item.Items;
import ro.dmoca.Hero.Types.*;
import ro.dmoca.Missions.Mission1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Hero {
    private String name;
    private double life;
    private double attack;
    private double defense;
    private double level;
    private double experience;
    private String type;
    private Items[] myItems;
    public static double id;             // hero's ids
    public int contor = 0; // how many heroes i have
    public Inventory inventory;
    public Mission1 mission;

    public Hero(String name, double attack, double defense, String type) {
        this.name = name;
        this.life = 100.0;
        this.attack = attack;
        this.defense = defense;
        this.level = 1;
        this.experience = 0.0;
        this.type = type;
        this.myItems = new Items[5];
        this.id = ++contor;
        this.inventory = new Inventory();
    }

    public Hero(String name, double life, double attack, double defense, double level, double experience, String type,
                double id, Inventory inventory) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.experience = experience;
        this.type = type;
        this.myItems = new Items[5];
        this.id = id;
        this.inventory = inventory;
    }

    public static Hero createHero(String heroType, String heroName) {
        if (heroType.equals("Trojan")) {
            return new Trojan(heroName);
        } else if (heroType.equals("Archer")) {
            return new Archer(heroName);
        } else
            return null;
    }

    public void addInventoryItem(String itemType) {
        if (inventory.items.size() < level)
            inventory.addItem(itemType);
        else
            System.out.println("Your level is too low to add one more item in the inventory.");
    }

    public void addEquipment(int position, String heroType, String type) {
        if (position > 5) System.out.println("This position does not exist.");
        if (myItems[position - 1] == null) {
            myItems[position - 1] = myItems[position - 1].addItem(heroType, type);
            System.out.println("You have added a new " + myItems[position - 1].toString());
            addDamage(position);
            addDefense(position);
        } else
            System.out.println("You already have an item on this position. " + "Please put this item on a different" +
                    " position");
    }

    public void removeEquipment() {
    }

    private void addDamage(int position) {
        this.attack = this.attack + myItems[position - 1].getDamage();
        System.out.println("Your new attack is " + this.attack);
    }

    private void addDefense(int position) {
        this.defense = this.defense + myItems[position - 1].getDefense();
        System.out.println("Your new defense is " + this.defense);
    }

    public boolean equals(Object o) {
        if (o instanceof Hero) {
            Hero hero = (Hero) o;
            return this.name == hero.name;
        } else {
            return false;
        }
    }

    public void choseMission(int option) {
        if (option == 1) {
            //mission = new Mission1.mission1();
            //mission.mission1(this.attack, this.defense, this.life);
        }
    }

    public static Hero loadHero() {
        Flux flux = new Flux();
        flux.readFile();
        int endName;
        String name = flux.getString().substring(0, ((endName = (((flux.getString().indexOf(" "))) + 1))));
        System.out.println(name);
        String temp;
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double life = Double.parseDouble(temp);
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double attack = Double.parseDouble(temp);
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double defense = Double.parseDouble(temp);
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double level = Double.parseDouble(temp);
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double experience = Double.parseDouble(temp);
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        String type = temp;
        temp = flux.getString().substring(endName, endName = flux.getString().indexOf(" ", endName + 1));
        double id = Double.parseDouble(temp);

        boolean advance = false;
        advance = flux.getString().contains("Blade");   // if exist any items please add them
        if (!advance)   {
            advance = flux.getString().contains("Bow");
        }
        if (advance) {
            temp = flux.getString().substring(endName + 2, endName = flux.getString().indexOf(",", endName));
        }
        if (temp != null) {
            Inventory newInventory = new Inventory();
            newInventory.addItem(temp);
            return new Hero(name, life, attack, defense, level, experience, type,
                    id, newInventory);
        } else {
            Inventory newInventory = new Inventory();
            return new Hero(name, life, attack, defense, level, experience, type,
                    id, newInventory);
        }
    }

    public void saveHero()  {
        Flux flux = new Flux();
        flux.writeFile(this.name + " " + this.life + " " + this.attack + " " + this.defense + " " +
                this.level + " " + this.experience + " " + this.type + " " + this.id + " " +
                this.inventory.items.toString());
    }

    public void save2Hero() {   // after first save
        Flux flux = new Flux();
        flux.writeFile(this.name + "" + this.life + " " + this.attack + " " + this.defense + " " +
                this.level + " " + this.experience + "" + this.type + " " + this.id + " " +
                this.inventory.items.toString());
    }

    @Override
    public String toString() {
        return "Hero:" +
                "\nname='" + name + '\'' +
                ", \nlife=" + life +
                ", \nattack=" + attack +
                ", \ndefense=" + defense +
                ", \nlevel=" + level +
                ", \nexperience=" + experience +
                ", \ntype='" + type + '\'' +
                ", \nmyItems=" + Arrays.toString(myItems) +
                ", \nmyInventory=" + inventory.toString() +
                ", \nid=" + id;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
