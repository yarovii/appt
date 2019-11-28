package eu.cz.yarovii.project.view;

import java.awt.*;

//singleton
public class Hud {
    public static long score=0;
    public static long hiddenScore=0;
    public static long level=1;

    private Hud() {
    }

    public void tick(){
        hiddenScore++;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawString("Score: "+score, 15, 25);
        g.setColor(Color.red);
        g.drawString("Level: "+level, 15, 45);
    }

    public static Hud getInstance()
    {
        return new Hud();
    }
}
