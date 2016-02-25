package ro.dmoca.Hero;

import ro.dmoca.Hero.Inventory.Inventory;
import ro.dmoca.Hero.Item.Items;
import ro.dmoca.Hero.Types.*;
import ro.dmoca.Missions.Mission1;

import java.util.Arrays;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Hero {
    private String  name;
    private double  life;
    private double  attack;
    private double  defense;
    private int     level;
    private double  experience;
    private String  type;
    private Items[]  myItems;
    public int      id;             // hero's ids
    public static int contor = 0; // how many heroes i have
    public Inventory inventory;
    private Mission1  mission;

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

    public static Hero createHero(String heroType, String heroName){
        if (heroType.equals("Trojan"))  {
            return new Trojan(heroName);
        }
        else if (heroType.equals("Archer")) {
            return new Archer(heroName);
        }
        else
            return null;
    }

    public void addInventoryItem(String itemType)    {
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
        }
        else
            System.out.println("You already have an item on this position. " + "Please put this item on a different" +
                    " position");
    }

    public void removeEquipment(){} //

    private void addDamage(int position)    {
        this.attack = this.attack + myItems[position - 1].getDamage();
        System.out.println("Your new attack is " + this.attack);
    }

    private void addDefense(int position)   {
        this.defense = this.defense + myItems[position - 1].getDefense();
        System.out.println("Your new defense is " + this.defense);
    }

    public boolean equals(Object o) {
        if (o instanceof Hero)  {
            Hero hero = (Hero) o;
            return this.name == hero.name;
        } else {
            return false;
        }
    }

    public void choseMission(int option)    {
        if (option == 1)    {
            mission = new Mission1();
            mission.mission1(this.attack, this.defense, this.life);
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", attack=" + attack +
                ", defense=" + defense +
                ", level=" + level +
                ", experience=" + experience +
                ", type='" + type + '\'' +
                ", myItems=" + Arrays.toString(myItems) +
                ", id=" + id +
                '}';
    }
}
