package eu.cz.yarovii.project.mouseEvents.type;

import eu.cz.yarovii.project.mouseEvents.EventType;

public class MouseMoved {
    private int x, y;
    private boolean dragged;
    private EventType event;

    public MouseMoved(int x, int y, boolean dragged) {
        this.event = EventType.MOUSE_MOVED;
        this.x = x;
        this.y = y;
        this.dragged = dragged;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDragged() {
        return dragged;
    }

    public void setDragged(boolean dragged) {
        this.dragged = dragged;
    }

}
