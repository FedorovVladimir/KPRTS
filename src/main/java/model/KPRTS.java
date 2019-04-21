package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;

    public KPRTS() {
        isOnLight.put(Light.APK, true);
        isOnLight.put(Light.MB1, true);
    }

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

    public boolean click(Buttons button) {
        if (isOn) {
            if (button == Buttons.VOR) {
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, true);
                isOnLight.put(Light.DME, true);
            }
            if (button == Buttons.APK) {
                isOnLight.put(Light.APK, true);
                isOnLight.put(Light.VOR, false);
                isOnLight.put(Light.DME, false);
            }
            if (button == Buttons.DME) {
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, false);
                isOnLight.put(Light.DME, true);
            }
            return true;
        }
        return false;
    }

    public boolean isOn(Light light) {
        if (isOn) {
            return isOnLight.get(light);
        } else {
            return false;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public Panel getPanel(int i) {
        if (isOn) {
            return new Panel(i);
        } else {
            return new Panel(0);
        }
    }
}
