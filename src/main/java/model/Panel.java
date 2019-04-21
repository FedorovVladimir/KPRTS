package model;

public class Panel {

    private String str = "";

    public Panel(int i) {
        if (i == 1 || i == 2) {
            str = "   150,0";
        }
        if (i == 3) {
            str = "комп тлф";
        }
    }

    public String getText() {
        return str;
    }
}
