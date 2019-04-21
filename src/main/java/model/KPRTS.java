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

    public void turnOn(int state) {
        isOn = true;
    }

    public boolean isTurn() {
        return isOn;
    }

    boolean sparen = true;
    boolean vor = false;
    public boolean click(Buttons button) {
        if (isOn) {
            if (button == Buttons.DME) {
                if (vor) {
                    sparen = true;
                    isOnLight.put(Light.APK, false);
                    isOnLight.put(Light.VOR, true);
                    isOnLight.put(Light.DME, true);
                } else {
                    isOnLight.put(Light.APK, false);
                    isOnLight.put(Light.VOR, false);
                    isOnLight.put(Light.DME, true);
                }
            }
            if (button == Buttons.VOR) {
                if (vor) {
                    sparen = false;
                }
                if (sparen) {
                    isOnLight.put(Light.APK, false);
                    isOnLight.put(Light.VOR, true);
                    isOnLight.put(Light.DME, true);
                } else {
                    isOnLight.put(Light.APK, false);
                    isOnLight.put(Light.VOR, true);
                    isOnLight.put(Light.DME, false);
                }
                vor = true;
            } else {
                vor = false;
            }
            if (button == Buttons.APK) {
                isOnLight.put(Light.APK, true);
                isOnLight.put(Light.VOR, false);
                isOnLight.put(Light.DME, false);
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
