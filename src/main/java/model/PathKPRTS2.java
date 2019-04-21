package model;

import java.util.HashMap;
import java.util.Map;

public class PathKPRTS2 implements PathKPRTS {
    // лампочки
    Map<String, Boolean> lights = new HashMap<String, Boolean>(){{
        put("MB1", true);
        put("MB2", false);
        put("MB3", false);
        put("DKMB1", false);
        put("DKMB2", false);
        put("B833", false);
    }};

    @Override
    public boolean isOnLight(String lightName) {
        if (lights.get(lightName) != null) {
            return lights.get(lightName);
        } else {
            return false;
        }
    }

    @Override
    public void click(String button) {

    }

    @Override
    public String getPanel(int i) {
        return "        ";
    }

    @Override
    public void clickRight(int size) {

    }
}
