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
        if (state == 0) {
            isOn = false;
        } else {
            isOn = true;
        }
    }

    public boolean isTurn() {
        return isOn;
    }

    boolean sparen = true;
    boolean vor = false;
    boolean rassparen = false;
    public boolean click(String button) {
        if (isOn) {
            if (button.equals(Buttons.DME.toString())) {
                if (!sparen && vor && !rassparen) {
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
            if (button.equals(Buttons.VOR.toString())) {
                if (vor) {
                    sparen = false;
                    rassparen = true;
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
                rassparen = false;
            }
            if (button.equals(Buttons.APK.toString())) {
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

    public boolean isOnLight(String lightName) {
        if (isOn) {
            for (Light light : isOnLight.keySet()) {
                if (light.toString().equals(lightName) && isOnLight.get(light))
                    return true;
            }
        }
        return false;
    }
}
