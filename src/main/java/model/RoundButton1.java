package model;

import java.util.Map;

class RoundButton1 {
    void clickRight(Map<Integer, String> panels, int size, boolean isAZ) {
        if (isAZ) {
            if (size > 0) {
                panels.put(2, "  Аз   1");
            } else {
                panels.put(2, "  Аз   0");
            }
        } else {
            if (size > 0) {
                panels.put(2, "   150,5");
            } else {
                panels.put(2, "   150,0");
            }
        }
    }
}
