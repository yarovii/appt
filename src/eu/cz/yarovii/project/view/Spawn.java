package eu.cz.yarovii.project.view;

import eu.cz.yarovii.project.Application;
import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.enemyUtil.enemies.BigEnemy;
import eu.cz.yarovii.project.enemyUtil.enemies.SpeedyEnemy;

import java.util.Random;

public class Spawn {
    private EnemyHandler handler;
    private Hud hud = Hud.getInstance();
    private Application app;
    private Random r = new Random();
    private long newLevel=120;
    public int localCount;  //counts if there 12 or more enemies for a long time
    private GameOver gameOver;

    public Spawn(EnemyHandler handler, Application app, GameOver gameOver) {
        this.handler = handler;
        this.app = app;
        this.gameOver = gameOver;
        localCount =0;
    }

    public void tick(){
        if(handler.getCountEnemy() <= 6) {
            app.setIsStopped(false);
            localCount = 0;
            if (hud.hiddenScore % 70 == 0) {
                handler.addEnemy(new BigEnemy(r.nextInt(app.WIDTH), r.nextInt(app.HEIGHT), handler));
                if (hud.score >= newLevel) {
                    hud.level++;
                    newLevel += 120;
                }
            } else if (hud.hiddenScore % 200 == 0) {
                handler.addEnemy(new SpeedyEnemy(r.nextInt(app.WIDTH), r.nextInt(app.HEIGHT), handler));
            }
        }else if(localCount >= 120){
            gameOver.stopAllEnemies(handler, this);
            app.setIsStopped(true);
            localCount=0;
        }
        else
            localCount++;

    }
}
