package model;

public class PathKPRTS2 extends PathKPRTS {

    private boolean[] state = new boolean[]{
            false,
            true,
            false,
            false,
            false,
            false,
    };

    private boolean[] ps = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
    };

    private boolean[] am = new boolean[]{
            false,
            false,
            false,
            false,
            false,
            false,
            false,
    };

    PathKPRTS2() {
        allLights_off();
        lights.put("MB1", true);
        panels.put(4, " 118,000");
        panels.put(5, " 118,000");
        panels.put(6, "ПШ      ");
    }

    @Override
    public void click(String button) {
        if (button.equals("MB1")) {
            setState(1);
            updatePS(1);
            allLights_off();
            lights.put("MB1", true);
            panels.put(4, " 118,000");
            panels.put(6, "ПШ      ");
        }
        if (button.equals("MB2")) {
            setState(2);
            updatePS(2);
            allLights_off();
            lights.put("MB2", true);
        }
        if (button.equals("MB3")) {
            setState(3);
            updatePS(3);
            allLights_off();
            panels.put(4, "САОД   Д");
            panels.put(6, "САОД   Д");
            lights.put("MB3", true);
        }
        if (button.equals("DKMB1")) {
            setState(4);
            updatePS(4);
            allLights_off();
            panels.put(4, "2000,000");
            panels.put(5, "2000,000");
            lights.put("DKMB1", true);
        }
        if (button.equals("DKMB2")) {
            setState(5);
            updatePS(5);
            allLights_off();
            panels.put(4, "2000,000");
            panels.put(5, "2000,000");
            lights.put("DKMB2", true);
        }
        if (button.equals("PS")) {
            int k = getState();
            ps[k] = !ps[k];
            updatePS(k);
        }
        if (button.equals("AM")) {
            int k = getState();
            am[k] = !am[k];
            updatePS(k);
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

    private void setState(int n) {
        for (int i = 0; i < state.length; i++) {
            state[i] = false;
        }
        state[n] = true;
    }

    private int getState() {
        for (int i = 0; i < state.length; i++) {
            if (state[i]) {
                return i;
            }
        }
        return -1;
    }

    private void updatePS(int k) {
        if (ps[k]) {
            if (am[k]) {
                panels.put(6, "ПШ    AM");
            } else {
                panels.put(6, "ПШ      ");
            }
        } else {
            if (am[k]) {
                panels.put(6, "      AM");
            } else {
                panels.put(6, "        ");
            }
        }
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
