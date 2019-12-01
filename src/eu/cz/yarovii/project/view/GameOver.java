package eu.cz.yarovii.project.view;

import eu.cz.yarovii.project.Application;
import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.mouseEvents.EventListener;
import eu.cz.yarovii.project.mouseEvents.type.MouseButton;

import java.awt.*;

public class GameOver implements EventListener {
    private Hud hud;
    private EnemyHandler handler;
    private Spawn spawn;

    public GameOver(EnemyHandler handler) {
        this.handler = handler;
    }

    public void render(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(Application.WIDTH/2 - 700/2, Application.HEIGHT/2 - 400/2, 700, 400);

        Font fnt = new Font("arial", 1, 50);
        g.setColor(Color.WHITE);
        g.setFont(fnt);
        g.drawString("Game Over", 280, 250);

        fnt = new Font("arial", 1, 30);
        g.setColor(Color.WHITE);
        g.setFont(fnt);
        g.drawString("Your score: "+ hud.score, 286, 300);

        g.drawRect(240,350,200,64);
        g.drawString("Play", 310, 392);

        g.drawRect(500,350,200,64);
        g.drawString("Quit", 565, 392);

    }

    public void stopAllEnemies(EnemyHandler handler, Spawn spawn){
        handler.stopAllEnemies();
        this.spawn = spawn;
    }

    public Rectangle getBoundsPlayButton(){
        return new Rectangle(240,350,200,64);
    }
    public Rectangle getBoundsQuitButton(){
        return new Rectangle(500,350,200,64);
    }

    public void onEvent(MouseButton e) {
        if (getBoundsPlayButton().contains(new Point(e.getX(), e.getY()))) {
            hud = Hud.getInstance();
            handler.removeAllEnemies();
            spawn.localCount =0;
        }
        else if(getBoundsQuitButton().contains(new Point(e.getX(), e.getY()))){
            System.exit(1);
        }
    }

}
