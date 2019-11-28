package eu.cz.yarovii.project.enemyUtil.enemies;

import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.enemyUtil.EnemyObject;
import eu.cz.yarovii.project.mouseEvents.type.MouseButton;

import java.awt.*;
import java.util.Random;

public class SpeedyEnemy extends EnemyObject {
    private Random r = new Random();

    public SpeedyEnemy(int x, int y, EnemyHandler handler) {
        super(x, y, handler);
        setVelX(r.nextInt(12+5));
        setVelY(r.nextInt(12+5));
        setColor(Color.GREEN);
        setWidth(30);
        setHeight(30);
        setValue(30);
    }
}
