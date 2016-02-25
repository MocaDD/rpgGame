package ro.dmoca.Hero.Types;

import ro.dmoca.Hero.Hero;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Archer extends Hero {
    public Archer(String name) {
        super(name, 15, 10, "Archer");
        System.out.println("A new Archer has been created.");
    }
}
