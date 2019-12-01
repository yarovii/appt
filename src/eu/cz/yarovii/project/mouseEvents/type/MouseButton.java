package eu.cz.yarovii.project.mouseEvents.type;

import eu.cz.yarovii.project.mouseEvents.EventType;

public class MouseButton {
    private int x, y, keyCode;
    private EventType event;

    public MouseButton(int x, int y, int keyCode, EventType event) {
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;
        this.event = event;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public EventType getEvent() {
        return event;
    }
}
