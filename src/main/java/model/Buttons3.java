package model;

import java.util.Map;

public class Buttons3 {

    private boolean sparen = true;
    private boolean vor = false;
    private boolean rassparen = false;

    public void click(Buttons button, Map<Light, Boolean> isOnLight, Map<Integer, String> panels, KPRTS kprts) {
        if (button == Buttons.DME) {
            if (!sparen && vor && !rassparen) {
                sparen = true;
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, true);
                isOnLight.put(Light.DME, true);
                panels.put(1, "  108,00");
                panels.put(2, "  Аз   0");
                panels.put(3, "СПАРЕН П");
            } else {
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, false);
                isOnLight.put(Light.DME, true);
                panels.put(1, "  108,00");
                panels.put(2, "  108,00");
                panels.put(3, "        ");
            }
        }
        if (button == Buttons.VOR) {
            kprts.setAz(true);
            if (vor) {
                sparen = false;
                rassparen = true;
            }
            if (sparen) {
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, true);
                isOnLight.put(Light.DME, true);
                panels.put(1, "  108,00");
                panels.put(2, "  Аз   0");
                panels.put(3, "СПАРЕН П");
            } else {
                isOnLight.put(Light.APK, false);
                isOnLight.put(Light.VOR, true);
                isOnLight.put(Light.DME, false);
                panels.put(1, "  108,00");
                panels.put(2, "  Аз   0");
                panels.put(3, "       П");
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
            panels.put(1, "   150,0");
            panels.put(2, "   150,0");
            panels.put(3, "КОМП ТЛФ");
        }
    }
}
