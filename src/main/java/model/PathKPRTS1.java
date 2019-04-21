package model;

import javax.inject.Named;

public class PathKPRTS1 extends PathKPRTS {

    private Buttons3 first = new Buttons3();
    private RoundButton1 roundButton = new RoundButton1();

    PathKPRTS1() {
        lights.put("APK", true);
        lights.put("VOR", false);
        lights.put("DME", false);
        lights.put("ILS", false);
        lights.put("MLS", false);
        lights.put("RSBN", false);
        lights.put("MRP", false);

        panels.put(0, "        ");
        panels.put(1, "   150,0");
        panels.put(2, "   150,0");
        panels.put(3, "КОМП ТЛФ");
    }

    private boolean az = false;

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
    public void clickRight(int size) {
        roundButton.clickRight(panels, size, getAz());
    }

    void setAz(boolean az) {
        this.az = az;
    }

    private boolean getAz() {
        return az;
    }
}
