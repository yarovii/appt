package eu.cz.yarovii.project.enemyUtil.enemies;

import eu.cz.yarovii.project.enemyUtil.EnemyObject;

import java.awt.*;
import java.util.Random;

public class BigEnemy extends EnemyObject {
    private Random r = new Random();

    public BigEnemy(int x, int y) {
        super(x, y);
        setVelX(r.nextInt(5));
        setVelY(r.nextInt(5));
        setColor(Color.CYAN);
        setWidth(35);
        setHeight(35);
        setValue(15);
    }
}
