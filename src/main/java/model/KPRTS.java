package model;

public class KPRTS {

    private boolean isApkOn = false;

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
}
