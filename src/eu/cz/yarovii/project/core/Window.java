package eu.cz.yarovii.project.core;

import eu.cz.yarovii.project.Application;
import eu.cz.yarovii.project.enemyUtil.EnemyHandler;
import eu.cz.yarovii.project.mouseEvents.type.MouseButton;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{
    private JFrame frame;

    public Window(String name, int width, int height, Application app) {
        //setPreferredSize(new Dimension(width, height));
        this.requestFocus();
        frame = new JFrame(name);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(app);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public Window() {
    }

}
