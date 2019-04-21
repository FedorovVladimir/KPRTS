package model;

import java.util.HashMap;
import java.util.Map;

public class PathKPRTS1 implements PathKPRTS {

    Buttons3 first = new Buttons3();
    RoundButton1 roundButton1 = new RoundButton1();

    // лампочки
    Map<String, Boolean> lights = new HashMap<String, Boolean>(){{
        put("APK", true);
        put("VOR", false);
        put("DME", false);
        put("ILS", false);
        put("MLS", false);
        put("RSBN", false);
        put("MRP", false);
    }};

    // текстовые панели
    Map<Integer, String> panels = new HashMap<Integer, String>(){{
        put(0, "        ");
        put(1, "   150,0");
        put(2, "   150,0");
        put(3, "КОМП ТЛФ");
    }};

    private boolean az = false;

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
        if (button.equals("upSwap")) {
            String dop = panels.get(1);
            panels.put(1, panels.get(2));
            panels.put(2, dop);
            return;
        }
        if (button.equals("MFK")) {
            if (panels.get(3).equals("КОМП ТЛФ")) {
                panels.put(3, "КОМП ТЛГ");
            } else if (panels.get(3).equals("КОМП ТЛГ")) {
                panels.put(3, "АНТ  ТЛФ");
            } else if (panels.get(3).equals("АНТ  ТЛФ")) {
                panels.put(3, "АНТ  ТЛГ");
            } else  {
                panels.put(3, "КОМП ТЛГ");
            }
            setAz(!getAz());
            return;
        }
        if (button.equals("APK") || button.equals("VOR") || button.equals("DME")) {
            first.click(button, this);
        }
    }

    @Override
    public String getPanel(int i) {
        return panels.get(i);
    }

    @Override
    public void clickRight(int size) {
        roundButton1.clickRight(panels, size, getAz());
    }

    void setAz(boolean az) {
        this.az = az;
    }

    public boolean getAz() {
        return az;
    }
}
