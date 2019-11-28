package eu.cz.yarovii.project.mouseEvents.type;

import eu.cz.yarovii.project.mouseEvents.EventType;

public class MousePressed extends MouseButton {
    public MousePressed(int x, int y, int keyCode) {
        super(x, y, keyCode, EventType.MOUSE_PRESSED);
    }
}
