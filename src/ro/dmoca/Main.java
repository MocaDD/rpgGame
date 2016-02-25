package ro.dmoca;

import ro.dmoca.FileWork.Flux;
import ro.dmoca.Hero.Hero;
import ro.dmoca.Hero.Types.Trojan;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Main {
    private static Hero myHero = new Trojan("Arlekino");
    public static void main(String[] args) {
        myHero.choseMission(1);
        Flux flux = new Flux();
        flux.readAndWrite("ana", "are");
    }
}
