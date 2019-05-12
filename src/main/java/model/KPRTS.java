package model;

public class KPRTS {

    private PathKPRTS[] path1 = new PathKPRTS1[3];

    private PathKPRTS[] path2 = new PathKPRTS2[3];

    private boolean on = false;

    private int state = 0;

    public KPRTS() {
        path1[1] = new PathKPRTS1();
        path1[2] = new PathKPRTS1();
        path2[1] = new PathKPRTS2();
        path2[2] = new PathKPRTS2();
    }

    public void turnOn(int state) {
        this.state = state;
        on = state == 1 || state == 2;
        if (state == 0) {
            path1[1] = new PathKPRTS1();
            path1[2] = new PathKPRTS1();
            path2[1] = new PathKPRTS2();
            path2[2] = new PathKPRTS2();
        }
    }

    public void click(String button) {
        if (on) {
            path1[state].click(button);
            path2[state].click(button);
        }
    }

    public String getTextFromPanel(int i) {
        if (on) {
            if (i > 0 && i < 4) {
                return path1[state].getPanel(i);
            } else {
                return path2[state].getPanel(i);
            }
        } else {
            return "        ";
        }
    }

    public boolean isLight(String lightName) {
        return on && ((path1[state].isOnLight(lightName) || path2[state].isOnLight(lightName)));
    }

    public void clickRight(int number, int size) {
        if (number == 1) {
            path1[state].clickRight(size);
        } else {
            path2[state].clickRight(size);
        }
    }

    public void click_on(String button) {
        if (on) {
            path1[state].click_on(button);
            path2[state].click_on(button);
        }
    }

    public void click_off(String button) {
        if (on) {
            path1[state].click_off(button);
            path2[state].click_off(button);
        }
    }
}
