package ro.dmoca.Hero.Types;

import ro.dmoca.Hero.Hero;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Trojan extends Hero {

    public Trojan(String name) {
        super(name, 20, 10, "Trojan");
        System.out.println("A new Trojan has been created.");
    }
}
