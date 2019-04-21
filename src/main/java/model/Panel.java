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
        if (i == 4 || i == 5) {
            str = "   118,0";
        }
        if (i == 6) {
            str = "пш      ";
        }
    }

    public String getText() {
        return str;
    }
}
