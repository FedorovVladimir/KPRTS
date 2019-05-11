package model;

public class PathKPRTS2 extends PathKPRTS {

    PathKPRTS2() {
        allLights_off();
        lights.put("MB1", true);
        panels.put(4, " 118,000");
        panels.put(5, " 118,000");
        panels.put(6, "ПШ      ");
    }

    @Override
    public void click(String button) {
        if (button.equals("MB2")) {
            allLights_off();
            lights.put("MB2", true);
        }
        if (button.equals("MB3")) {
            allLights_off();
            panels.put(4, "САОД   Д");
            panels.put(6, "САОД   Д");
            lights.put("MB3", true);
        }
    }

    @Override
    public void clickRight(int size) {

    }

    @Override
    void click_on(String button) {

    }

    @Override
    void click_off(String button) {

    }

    private void allLights_off() {
        lights.put("MB1", false);
        lights.put("MB2", false);
        lights.put("MB3", false);
        lights.put("DKMB1", false);
        lights.put("DKMB2", false);
        lights.put("B833", false);
    }
}
