package ro.dmoca;

import ro.dmoca.*;
//import ro.dmoca.Gui.LoadHero;
import ro.dmoca.Gui.LoadHero;
import ro.dmoca.Gui.Menu;
import ro.dmoca.Hero.Hero;

public class Main   {
    private Hero newHero = Hero.createHero("Trojan", "Arlekino");
    public static void main(String[] args) {
        Menu s = new Menu();
        s.setVisible(true);
        LoadHero hero = new LoadHero();
        hero.getdata = "ana";
        hero.postData();
    }

}