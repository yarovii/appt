package eu.cz.yarovii.project.mouseEvents;

import eu.cz.yarovii.project.mouseEvents.type.MouseButton;
import eu.cz.yarovii.project.mouseEvents.type.MousePressed;

import java.awt.*;

public class EventController {
    private MouseButton mouseButton;

    public EventController(MouseButton mouseButton) {
        this.mouseButton = mouseButton;
    }

    public void control(EventType event, EventHandler handler){
        if(mouseButton.handled)
            return;
        if(mouseButton.getEvent() == event)
            handler.handle(event);
    }
}
