package ro.dmoca.Hero.Item;

import ro.dmoca.Hero.Item.Types.Blade;
import ro.dmoca.Hero.Item.Types.Bow;
import ro.dmoca.Hero.Item.Types.Sword;


/**
 * Created by MocaDD on 2/25/2016.
 */
public class Items {
    private double damage;
    private double defense;
    private String type;

    public Items(double damage, double defense, String type) {
        this.damage = damage;
        this.defense = defense;
        this.type = type;
    }

    public static Items createItem(String type)  {
        if (type.equals("Blade"))   {
            return new Blade();
        } else if (type.equals("Sword"))
            return new Sword();
        else if (type.equals("Bow"))
            return new Bow();
        return null;
    }

    public static Items addItem(String heroType, String type)   {
        if (heroType.equals("Trojan") && type.equals("Blade"))
            return createItem(type);
        return null;
    }

    @Override
    public String toString() {
        return (this.getType() +
                ", Damage:"+this.getDamage()+
                ", Defense: "+ this.getDefense());
    }

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public String getType() {
        return type;
    }
}
