package model;

public class PathKPRTS2 extends PathKPRTS {

    PathKPRTS2() {
        lights.put("MB1", true);
        lights.put("MB2", false);
        lights.put("MB3", false);
        lights.put("DKMB1", false);
        lights.put("DKMB2", false);
        lights.put("B833", false);

        panels.put(0, "        ");
    }

    @Override
    public void click(String button) {

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
}
