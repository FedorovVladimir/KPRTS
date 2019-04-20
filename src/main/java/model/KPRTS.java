package model;

public class KPRTS {

    private boolean isApkOn = false;
    private boolean isVorOn = false;

    public void turnOn() {

    }

    public boolean isTurn() {
        return true;
    }

    public void clickApk() {
        isApkOn = !isApkOn;
    }

    public boolean isApkOn() {
        return isApkOn;
    }

    public boolean isApkOff() {
        return !isApkOn;
    }

    public void clickVor() {
        isVorOn = !isVorOn;
    }

    public boolean isVorOn() {
        return isVorOn;
    }

    public boolean isVorOff() {
        return !isVorOn;
    }
}
