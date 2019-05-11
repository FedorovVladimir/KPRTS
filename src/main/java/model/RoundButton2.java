package model;

import java.util.Map;

class RoundButton2 {

    // max = 136.975
    private double number5 = 118.0;

    void clickRight(int size, PathKPRTS2 kprts2) {
        number5 += 0.025 * size;
        if (number5 < 118.0) {
            number5 = 118.0;
        }
        if (number5 > 136.975) {
            number5 = 136.975;
        }
        kprts2.panels.put(5, String.format(" %3.3f", number5));
    }
}
