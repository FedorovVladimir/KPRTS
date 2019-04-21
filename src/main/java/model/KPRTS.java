package model;

public class KPRTS {

    private PathKPRTS path1 = new PathKPRTS1();

    private PathKPRTS path2 = new PathKPRTS2();

    private boolean on = false;

    public void turnOn(int state) {
        on = state == 1 || state == 2;
    }

    public void click(String button) {
        if (on) {
            if (button.equals("APK") || button.equals("VOR") || button.equals("DME") || button.equals("upSwap") || button.equals("MFK")) {
                path1.click(button);
            }
        }
    }

    public String getTextFromPanel(int i) {
        if (on) {
            if (i > 0 && i < 4) {
                return path1.getPanel(i);
            } else {
                return path2.getPanel(i);
            }
        } else {
            return "        ";
        }
    }

    public boolean isLight(String lightName) {
        return on && ((path1.isOnLight(lightName) || path2.isOnLight(lightName)));
    }

    public void clickRight(int number, int size) {
        if (number == 1) {
            path1.clickRight(size);
        } else {
            path2.clickRight(size);
        }
    }
}
