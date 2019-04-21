package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;

    private Map<Buttons, Boolean> isOnButtons = new HashMap<Buttons, Boolean>(){{
        for (Buttons button : Buttons.values()) {
            put(button, false);
        }
    }};

    public void turnOn() {
        isOn = true;
    }

    public boolean isTurn() {
        return isOn;
    }

    public void click(Buttons button) {
        if (isOn) {
            isOnButtons.put(button, !isOnButtons.get(button));
        }
    }

    public boolean isOn(Buttons button) {
        return isOnButtons.get(button);
    }

    public boolean isOff(Buttons button) {
        return !isOnButtons.get(button);
    }

    public boolean isOn(Light light) {
        return true;
    }

    public void turnOff() {

    }
}
