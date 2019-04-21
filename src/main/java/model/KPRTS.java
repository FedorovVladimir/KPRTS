package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;

    public KPRTS() {
        isOnLight.put(Light.APK, true);
        isOnLight.put(Light.MB1, true);
    }

    private Map<Buttons, Boolean> isOnButtons = new HashMap<Buttons, Boolean>(){{
        for (Buttons button : Buttons.values()) {
            put(button, false);
        }
    }};

    private Map<Light, Boolean> isOnLight = new HashMap<Light, Boolean>(){{
        for (Light light : Light.values()) {
            put(light, false);
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

    public boolean isOn(Light light) {
        return isOnLight.get(light);
    }

    public void turnOff() {
        isOnLight.put(Light.APK, false);
        isOnLight.put(Light.MB1, false);
    }
}
