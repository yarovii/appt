package eu.cz.yarovii.project.enemyUtil.enemies;

import eu.cz.yarovii.project.enemyUtil.EnemyObject;

import java.awt.*;
import java.util.Random;

public class SpeedyEnemy extends EnemyObject {
    private Random r = new Random();

    public SpeedyEnemy(int x, int y) {
        super(x, y);
        setVelX(r.nextInt(12+5));
        setVelY(r.nextInt(12+5));
        setColor(Color.GREEN);
        setWidth(30);
        setHeight(30);
        setValue(30);
    }
}
