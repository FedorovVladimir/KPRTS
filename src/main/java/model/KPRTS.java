package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;
    private Buttons3 first3 = new Buttons3();

    public KPRTS() {
        isOnLight.put(Light.APK, true);
        isOnLight.put(Light.MB1, true);
    }

    private Map<Light, Boolean> isOnLight = new HashMap<Light, Boolean>(){{
        for (Light light : Light.values()) {
            put(light, false);
        }
    }};

    private Map<Integer, String> panels = new HashMap<Integer, String>(){{
        put(0, "        ");
        put(1, "   150,0");
        put(2, "   150,0");
        put(3, "комп тлф");
        put(4, " 118,000");
        put(5, " 118,000");
        put(6, "пш      ");
    }};

    public void turnOn(int state) {
        isOn = state == 1 || state == 2;
    }

    public void click(String button) {
        if (isOn) {
            if (button.equals(Buttons.APK.toString())) {
                first3.click(Buttons.APK, isOnLight, panels);
            }
            if (button.equals(Buttons.VOR.toString())) {
                first3.click(Buttons.VOR, isOnLight, panels);
            }
            if (button.equals(Buttons.DME.toString())) {
                first3.click(Buttons.DME, isOnLight, panels);
            }
        }
    }

    public String getPanel(int i) {
        if (isOn) {
            return panels.get(i);
        } else {
            return panels.get(0);
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
