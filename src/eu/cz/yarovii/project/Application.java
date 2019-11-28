package eu.cz.yarovii.project;

import eu.cz.yarovii.project.core.Window;
import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.enemyUtil.enemies.BigEnemy;
import eu.cz.yarovii.project.mouseEvents.EventController;
import eu.cz.yarovii.project.mouseEvents.type.MousePressed;
import eu.cz.yarovii.project.mouseEvents.type.MouseReleased;
import eu.cz.yarovii.project.view.Hud;
import eu.cz.yarovii.project.view.Spawn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Application extends Canvas implements Runnable{
    public static final int WIDTH = 960, HEIGHT=640;
    private boolean isRunning;
    private Thread thread;
    EnemyHandler handler;
    private Window window;
    private BufferStrategy bs;
    private Graphics g;
    private Spawn spawner;
    private Random r;
    private Hud hud;
    private EventController controller;


    public Application() {
        handler = new EnemyHandler();
        r = new Random();
        hud = Hud.getInstance();
        new Window("Application", WIDTH, HEIGHT, this);
        start();

        spawner = new Spawn(handler);

        handler.addEnemy(new BigEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT), handler));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MousePressed event = new MousePressed(e.getX(), e.getY(), e.getButton());
                handler.onEvent(event);
            }
            public void mouseReleased(MouseEvent e) {
                MouseReleased event = new MouseReleased(e.getButton(), e.getX(), e.getY());
                handler.onEvent(event);
            }
        });
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (isRunning){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime=now;

            while (delta >=1){
                tick();
                delta--;
            }

            if(isRunning)
                render();

            frames++;

            if(System.currentTimeMillis()-timer > 1000){
                timer+=1000;
                //System.out.println("FPS "+frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        try{
            thread.join();
            isRunning = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void render() {
        if(bs == null)
            createBufferStrategy(3);
        bs = getBufferStrategy();

        g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }
    private void tick(){
        hud.tick();
        spawner.tick();
        handler.tick();
    }

}
