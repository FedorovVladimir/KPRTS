package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;

    public KPRTS() {
        isOnLight.put(Light.APK, true);
        isOnLight.put(Light.MB1, true);
    }

    private Buttons3 first3 = new Buttons3();

    private Map<Light, Boolean> isOnLight = new HashMap<Light, Boolean>(){{
        for (Light light : Light.values()) {
            put(light, false);
        }
    }};

    public void turnOn(int state) {
        isOn = state == 1 || state == 2;
    }

    public void click(String button) {
        if (isOn) {
            if (button.equals(Buttons.APK.toString())) {
                first3.click(Buttons.APK, isOnLight);
            }
            if (button.equals(Buttons.VOR.toString())) {
                first3.click(Buttons.VOR, isOnLight);
            }
            if (button.equals(Buttons.DME.toString())) {
                first3.click(Buttons.DME, isOnLight);
            }
        }
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
