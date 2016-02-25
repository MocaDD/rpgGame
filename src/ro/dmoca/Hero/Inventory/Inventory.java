package ro.dmoca.Hero.Inventory;

import ro.dmoca.Hero.Item.Items;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Inventory {

    private Scanner scanner = new Scanner(System.in);
    public LinkedList<Items> items;

    public Inventory() {
        items = new LinkedList<Items>();
    }

    public void addItem(String itemType) {
        items.add(Items.createItem(itemType));
    }

    public void removeItem(int position) {
        items.remove(position);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}
