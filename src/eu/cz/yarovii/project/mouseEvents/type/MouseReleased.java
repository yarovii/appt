package eu.cz.yarovii.project.mouseEvents.type;

import eu.cz.yarovii.project.mouseEvents.EventType;

public class MouseReleased extends MouseButton {
    public MouseReleased(int x, int y, int keyCode) {
        super(x, y, keyCode, EventType.MOUSE_RELEASED);
    }
}
