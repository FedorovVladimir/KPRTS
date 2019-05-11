package model;

class RoundButton2 {

    // max = 136.975
    private double numberMB1 = 118.0;

    void clickRight(int size, PathKPRTS2 kprts2) {
        numberMB1 += 0.025 * size;
        if (numberMB1 < 118.0) {
            numberMB1 = 118.0;
        }
        if (numberMB1 > 136.975) {
            numberMB1 = 136.975;
        }
        kprts2.panels.put(5, String.format(" %3.3f", numberMB1));
    }
}
