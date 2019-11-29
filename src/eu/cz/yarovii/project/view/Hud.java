package eu.cz.yarovii.project.view;

import java.awt.*;

//singleton
public class Hud {
    public static long score=0;
    public static long bestScore=0;
    public static long hiddenScore=0;
    public static long level=1;

    private Hud() {
    }
    private Hud(long sc) {
        score=0;
        hiddenScore=0;
        level=1;
        this.bestScore = sc;
    }

    public void tick(){
        hiddenScore++;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawString("Score: "+score, 15, 25);
        g.setColor(Color.red);
        g.drawString("Best score: "+bestScore, 90, 25);
        g.setColor(Color.red);
        g.drawString("Level: "+level, 15, 45);
    }

    public static Hud getInstance()
    {
        return new Hud();
    }
    public static Hud getInstance(long sc)
    {
        return new Hud(sc);
    }
}
