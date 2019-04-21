package model;

interface PathKPRTS {
    boolean isOnLight(String lightName);

    void click(String button);

    String getPanel(int i);

    void clickRight(int size);
}
