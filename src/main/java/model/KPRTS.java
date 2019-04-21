package model;

import java.util.HashMap;
import java.util.Map;

public class KPRTS {

    private boolean isOn = false;
    private Buttons3 first3 = new Buttons3();
    private RoundButton1 roundButton1 = new RoundButton1();
    private Boolean isAZ = false;

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
        put(3, "КОМП ТЛФ");
        put(4, " 118,000");
        put(5, " 118,000");
        put(6, "ПШ      ");
    }};

    public void turnOn(int state) {
        isOn = state == 1 || state == 2;
    }

    public void click(String button) {
        if (isOn) {
            if (button.equals(Buttons.APK.toString())) {
                first3.click(Buttons.APK, isOnLight, panels, this);
            }
            if (button.equals(Buttons.VOR.toString())) {
                first3.click(Buttons.VOR, isOnLight, panels, this);
            }
            if (button.equals(Buttons.DME.toString())) {
                first3.click(Buttons.DME, isOnLight, panels, this);
            }
            if (button.equals("upSwap")) {
                String dop = panels.get(1);
                panels.put(1, panels.get(2));
                panels.put(2, dop);
            }
            if (button.equals(Buttons.MFK.toString())) {
                if (panels.get(3).equals("КОМП ТЛФ")) {
                    panels.put(3, "КОМП ТЛГ");
                } else if (panels.get(3).equals("КОМП ТЛГ")) {
                    panels.put(3, "АНТ  ТЛФ");
                } else if (panels.get(3).equals("АНТ  ТЛФ")) {
                    panels.put(3, "АНТ  ТЛГ");
                } else  {
                    panels.put(3, "КОМП ТЛГ");
                }
                isAZ = !isAZ;
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

    public void clickRight(int number, int size) {
        roundButton1.clickRight(panels, size, isAZ);
    }

    void setAz(boolean b) {
        isAZ = b;
    }
}
