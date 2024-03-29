package eu.cz.yarovii.project.enemyUtil;

import eu.cz.yarovii.project.Application;

import java.awt.*;

public class EnemyObject {
    private int x, y; //current location
    private int width, height; //size of Enemy
    private int velX, velY;  // speed
    private Color color;  //color of Enemy
    private int value;

    public EnemyObject(int x, int y) {
        this.x = x;
        this.y = y;
        checkIfWindow();
    }

    //Check if object has location in window
    private void checkIfWindow(){
        if(x+width >= Application.WIDTH)
            this.x = Application.WIDTH-width;
        if(y+height >= Application.HEIGHT)
            this.y = Application.HEIGHT-height;
    }

    public void tick(){
        x += velX;
        y += velY;
        //Check if it is edges of window
        if(y <= 0 || y > Application.HEIGHT-(height*1.5)+(height%2)){ velY *= -1;}
        if(x <= 0 || x > Application.WIDTH-width) velX *= -1;
    }

    public void render(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y,width,height);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

}
