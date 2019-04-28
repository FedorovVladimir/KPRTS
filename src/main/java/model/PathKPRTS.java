package model;

import java.util.HashMap;
import java.util.Map;

abstract class PathKPRTS {

    // текстовые панели
    Map<Integer, String> panels = new HashMap<Integer, String>();

    // лампочки
    Map<String, Boolean> lights = new HashMap<String, Boolean>();

    boolean isOnLight(String lightName) {
        if (lights.get(lightName) != null) {
            return lights.get(lightName);
        } else {
            return false;
        }
    }

    abstract void click(String button);

    String getPanel(int i) {
        return panels.get(i);
    }

    abstract void clickRight(int size);

    abstract void click_on(String button);

    abstract void click_off(String button);
}
