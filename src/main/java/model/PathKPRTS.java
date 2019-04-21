package model;

abstract class PathKPRTS {
    abstract boolean isOnLight(String lightName);

    abstract void click(String button);

    abstract String getPanel(int i);

    abstract void clickRight(int size);
}
