package eu.cz.yarovii.project;

import eu.cz.yarovii.project.core.Window;
import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.enemyUtil.enemies.BigEnemy;
import eu.cz.yarovii.project.mouseEvents.type.MousePressed;
import eu.cz.yarovii.project.view.GameOver;
import eu.cz.yarovii.project.view.Hud;
import eu.cz.yarovii.project.view.Spawn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Application extends Canvas implements Runnable{
    public static final int WIDTH = 960, HEIGHT=640;
    public boolean isRunning;
    private Thread thread;
    EnemyHandler handler = new EnemyHandler();;
    private BufferStrategy bs;
    private Graphics g;
    private Spawn spawner;
    private Random r = new Random();
    private Hud hud = Hud.getInstance();
    private GameOver gameOver;
    private static boolean isStopped;


    public Application() {
        isStopped = false;
        new Window("Application", WIDTH, HEIGHT, this);
        start();
        gameOver = new GameOver(handler);
        spawner = new Spawn(handler, gameOver);

        handler.addEnemy(new BigEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT)));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MousePressed event = new MousePressed(e.getX(), e.getY(), e.getButton());
                if(!isStopped)
                    handler.onEvent(event);
                else
                    gameOver.onEvent(event);
            }
        });
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();

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

            if(System.currentTimeMillis()-timer > 1000){
                timer+=1000;
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

        //render window
        g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());

        //render objects in window
        handler.render(g);
        hud.render(g);

        //render GaveOver window
        if(isStopped)
            gameOver.render(g);

        g.dispose();
        bs.show();
    }

    private void tick(){
        hud.tick();
        spawner.tick();
        handler.tick();
    }

    public static boolean isIsStopped() {
        return isStopped;
    }

    public static void setIsStopped(boolean isStopped) {
        Application.isStopped = isStopped;
    }
}
