package eu.cz.yarovii.project.view;

import java.awt.*;

public class Over {
    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawString("Score: "+score, 15, 25);
        g.setColor(Color.red);
        g.drawString("Level: "+level, 15, 45);
    }
}
