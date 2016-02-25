package ro.dmoca.Missions;

import ro.dmoca.Monster.Types.Roshan;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Mission1 {
    private static Roshan monster = new Roshan();

    public static void mission1(double heroAttack, double heroDefense, double heroLife)    {
        monster.getDamage(heroAttack);
        System.out.println(monster.getLife());
    }
}
