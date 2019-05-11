package model;

public class PathKPRTS2 extends PathKPRTS {

    // max = 136.975
    private double numberMB1 = 118.0;

    private double numberMB2 = 118.0;

    private double numberDKMB1 = 2000.0;

    private boolean rd = true;

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

    private boolean[] B833 = new boolean[]{
            false,
            false,
            false,
            false,
    };

    private boolean[] pa = new boolean[]{
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
            setNumberMB1();
            lights.put("MB1", true);
            panels.put(4, " 118,000");

            if (B833[1]) {
                lights.put("B833", true);
            }
        }
        if (button.equals("MB2")) {
            setState(2);
            updatePS(2);
            allLights_off();
            setNumberMB2();
            lights.put("MB2", true);

            if (B833[2]) {
                lights.put("B833", true);
            }
        }
        if (button.equals("MB3")) {
            setState(3);
            updatePS(3);
            allLights_off();
            if (rd) {
                panels.put(4, "САОД   Д");
                panels.put(6, "САОД   Д");
            }
            lights.put("MB3", true);

            if (B833[3]) {
                lights.put("B833", true);
            }
        }
        if (button.equals("DKMB1")) {
            setState(4);
            updatePS(4);
            allLights_off();
            setNumberDKMB1();
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
        if (button.equals("B833")) {
            int k = getState();
            if (k == 1 || k == 2 || k == 3) {
                B833[k] = !B833[k];
                lights.put("B833", true);
            }
        }
        if (button.equals("PA")) {
            int k = getState();
            if (k == 1 || k == 2 || k == 3) {
                pa[k] = !pa[k];
                updatePS(k);
            }
        }
        if (button.equals("RD")) {
            int k = getState();
            if (k == 3) {
                rd = !rd;
                if (rd) {
                    panels.put(4, "САОД   Д");
                } else {
                    panels.put(4, " 118,000");
                }
                updatePS(k);
            }
        }
    }

    @Override
    public void clickRight(int size) {
        int k = getState();
        if (k == 1) {
            numberMB1 += 0.025 * size;
            if (numberMB1 < 118.0) {
                numberMB1 = 118.0;
            }
            if (numberMB1 > 136.975) {
                numberMB1 = 136.975;
            }
            panels.put(5, String.format(" %3.3f", numberMB1));
        }
        if (k == 2) {
            numberMB2 += 0.025 * size;
            if (numberMB2 < 118.0) {
                numberMB2 = 118.0;
            }
            if (numberMB2 > 136.975) {
                numberMB2 = 136.975;
            }
            panels.put(5, String.format(" %3.3f", numberMB2));
        }
        if (k == 4) {
            numberDKMB1 += 0.025 * size;
            panels.put(5, String.format("%4.3f", numberDKMB1));
        }
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
        if (k == 3 && rd) {
            panels.put(6, "САОД   Д");
            return;
        }
        if (ps[k]) {
            if (am[k]) {
                panels.put(6, "ПШ    АМ");
            } else {
                if (pa[k]) {
                    panels.put(6, "ПШ    ПА");
                } else {
                    panels.put(6, "ПШ      ");
                }
            }
        } else {
            if (am[k]) {
                panels.put(6, "      АМ");
            } else {
                if (pa[k]) {
                    panels.put(6, "      ПА");
                } else {
                    panels.put(6, "        ");
                }
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

    private void setNumberMB1() {
        panels.put(5, String.format(" %3.3f", numberMB1));
    }

    private void setNumberMB2() {
        panels.put(5, String.format(" %3.3f", numberMB2));
    }

    private void setNumberDKMB1() {
        panels.put(5, String.format("%4.3f", numberDKMB1));
    }
}
