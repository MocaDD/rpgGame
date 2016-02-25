package ro.dmoca.Monster;

import ro.dmoca.Monster.Types.*;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Monsters {
    String type;
    double damage;
    double life;

    public Monsters(double damage, double life) {
        this.damage = damage;
        this.life = life;
    }

    public Monsters createMonster(String monsterType) {
        if (monsterType.equals("Roshan")) {
            this.type = monsterType;
            return new Roshan();
        } else if (monsterType.equals("Santinel"))  {
            this.type = monsterType;
            return new Santinel();
        }
        return null;
    }

    public void getDamage(double damage)    {
        this.life = this.life - damage;
    }

    public double getLife() {
        return life;
    }
}
