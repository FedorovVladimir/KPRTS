package model;

import java.util.Map;

class RoundButton1 {

    private int az = 0;
    private int nav = 1;
    private double a = 150.0;

    void clickRight(Map<Integer, String> panels, int size, State state) {
        if (state == State.AZ) {
            az += size;
            panels.put(2, String.format("  АЗ%4d", az));
        } else if (state == State.NAV) {
            nav += size;
            panels.put(2, String.format("НАВ %04d", nav));
        } else {
            a += size * 0.5;
            panels.put(2, String.format("%8.1f", a));
        }
    }
}
