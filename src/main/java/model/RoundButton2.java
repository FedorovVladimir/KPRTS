package model;

class RoundButton2 {

    // max = 136.975
    private double numberMB1 = 118.0;

    private double numberMB2 = 118.0;

    void clickRight(int size, PathKPRTS2 kprts2) {
        int k = kprts2.getState();
        if (k == 1) {
            numberMB1 += 0.025 * size;
            if (numberMB1 < 118.0) {
                numberMB1 = 118.0;
            }
            if (numberMB1 > 136.975) {
                numberMB1 = 136.975;
            }
            kprts2.panels.put(5, String.format(" %3.3f", numberMB1));
        }
        if (k == 2) {
            numberMB2 += 0.025 * size;
            if (numberMB2 < 118.0) {
                numberMB2 = 118.0;
            }
            if (numberMB2 > 136.975) {
                numberMB2 = 136.975;
            }
            kprts2.panels.put(5, String.format(" %3.3f", numberMB2));
        }
    }

    void setNumberMB1(PathKPRTS2 kprts2) {
        kprts2.panels.put(5, String.format(" %3.3f", numberMB1));
    }

    void setNumberMB2(PathKPRTS2 kprts2) {
        kprts2.panels.put(5, String.format(" %3.3f", numberMB2));
    }
}
