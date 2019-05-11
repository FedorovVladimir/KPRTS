package model;


public class PathKPRTS1 extends PathKPRTS {

    private Buttons3 first = new Buttons3();
    private RoundButton1 roundButton = new RoundButton1();
    private State roundState = State.NONE;

    PathKPRTS1() {
        allLights_off();
        lights.put("APK", true);
        panels.put(0, "        ");
        panels.put(1, "   150,0");
        panels.put(2, "   150,0");
        panels.put(3, "КОМП ТЛФ");
    }

    private boolean az = false;

    void setRoundState(State roundState) {
        this.roundState = roundState;
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
        if (button.equals("ILS")) {
            panels.put(1, "  108,10");
            panels.put(2, " ВПП   0");
            panels.put(3, "ПОСД ILS");
            allLights_off();
            lights.put("ILS", true);
        }
        if (button.equals("MLS")) {
            panels.put(1, "     500");
            panels.put(2, "  АЗ   0");
            panels.put(3, "        ");
            allLights_off();
            lights.put("MLS", true);
        }
        if (button.equals("RSBN")) {
            roundState = State.NAV;
            panels.put(1, "НАВ 0001");
            panels.put(2, "НАВ 0001");
            panels.put(3, "        ");
            allLights_off();
            lights.put("RSBN", true);
        }
        if (button.equals("MPR")) {
            lights.put("MPR", !lights.get("MPR"));
        }
    }

    @Override
    public void clickRight(int size) {
        roundButton.clickRight(panels, size, roundState);
    }

    @Override
    void click_on(String button) {
        if (button.equals("OPZ")) {
            panels.put(1, "ОПОЗНАВ ");
            panels.put(2, "ОПОЗНАВ ");
            panels.put(3, "        ");
            allLights_off();
            lights.put("RSBN", true);
        }
    }

    @Override
    void click_off(String button) {
        if (button.equals("OPZ")) {
            panels.put(1, "        ");
            panels.put(2, "        ");
            panels.put(3, "        ");
            allLights_off();
            lights.put("RSBN", true);
        }
    }

    void setAz(boolean az) {
        this.az = az;
    }

    private boolean getAz() {
        return az;
    }

    private void allLights_off() {
        lights.put("APK", false);
        lights.put("VOR", false);
        lights.put("DME", false);
        lights.put("ILS", false);
        lights.put("MLS", false);
        lights.put("RSBN", false);
        lights.put("MPR", false);
    }
}
