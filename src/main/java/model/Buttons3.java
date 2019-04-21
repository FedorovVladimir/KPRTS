package model;

import java.util.Map;

public class Buttons3 {

    private boolean sparen = true;
    private boolean vor = false;
    private boolean rassparen = false;

    public void click(Buttons button, Map<Light, Boolean> isOnLight) {
        if (button == Buttons.DME) {
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
        if (button == Buttons.VOR) {
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
        if (button == Buttons.APK) {
            isOnLight.put(Light.APK, true);
            isOnLight.put(Light.VOR, false);
            isOnLight.put(Light.DME, false);
        }
    }
}
