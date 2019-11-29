package eu.cz.yarovii.project.enemyUtil;

import eu.cz.yarovii.project.mouseEvents.EventListener;
import eu.cz.yarovii.project.mouseEvents.type.MouseButton;
import eu.cz.yarovii.project.view.Hud;

import java.awt.*;
import java.util.LinkedList;

public class EnemyHandler implements EventListener {
    LinkedList<EnemyObject> enemies = new LinkedList<EnemyObject>();
    private int countEnemy;
    private Hud hud = Hud.getInstance();

    public void render(Graphics g){
        for(int i=0; i<enemies.size(); i++)
            enemies.get(i).render(g);
    }

    public void tick(){
        for(int i=0; i < enemies.size(); i++)
            enemies.get(i).tick();
    }

    public void onEvent(MouseButton e) {
        for(int i=0; i < enemies.size(); i++) {
            if (enemies.get(i).getBounds().contains(new Point(e.getX(), e.getY()))) {
                hud.score += enemies.get(i).getValue();
                if(hud.score > hud.bestScore)
                    hud.bestScore = hud.score;
                removeEnemy(enemies.get(i));
                break;
            }
        }
    }

    public void addEnemy(EnemyObject eo){
        countEnemy++;
        enemies.add(eo);
    }

    public void removeEnemy(EnemyObject eo){
       enemies.remove(eo);
        countEnemy--;
    }
    public void stopAllEnemies(){
        for(int i=0; i<enemies.size(); i++){
            enemies.get(i).setVelX(0);
            enemies.get(i).setVelY(0);
        }
    }
    public void removeAllEnemies(){
        for(int i=enemies.size()-1; i>=0; i--){
            enemies.remove(enemies.get(i));
            countEnemy--;
        }
    }

    public int getCountEnemy() {
        return countEnemy;
    }
}
