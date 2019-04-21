package model;

public class KPRTS {

    private PathKPRTS path1 = new PathKPRTS1();
    private PathKPRTS path2 = new PathKPRTS2();

    private boolean isOn = false;

    public void turnOn(int state) {
        isOn = state == 1 || state == 2;
    }

    public void click(String button) {
        if (isOn) {
            if (button.equals("APK") || button.equals("VOR") || button.equals("DME") || button.equals("upSwap") || button.equals("MFK")) {
                path1.click(button);
            }
        }
    }

    public String getPanel(int i) {
        if (isOn && i > 0 && i < 4) {
            return path1.getPanel(i);
        } else {
            return path2.getPanel(i);
        }
    }

    public boolean isOnLight(String lightName) {
        return isOn && ((path1.isOnLight(lightName) || path2.isOnLight(lightName)));
    }

    public void clickRight(int number, int size) {
        if (number == 1) {
            path1.clickRight(size);
        } else {
            path2.clickRight(size);
        }
    }
}
