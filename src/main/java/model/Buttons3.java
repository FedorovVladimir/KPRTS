package model;

class Buttons3 {

    private boolean sparen = true;
    private boolean vor = false;
    private boolean rassparen = false;

    void click(String button, PathKPRTS1 path) {
        if (button.equals("DME")) {
            if (!sparen && vor && !rassparen) {
                sparen = true;
                path.lights.put("APK", false);
                path.lights.put("VOR", true);
                path.lights.put("DME", true);
                path.panels.put(1, "  108,00");
                path.panels.put(2, "  Аз   0");
                path.panels.put(3, "СПАРЕН П");
            } else {
                path.lights.put("APK", false);
                path.lights.put("VOR", false);
                path.lights.put("DME", true);
                path.panels.put(1, "  108,00");
                path.panels.put(2, "  108,00");
                path.panels.put(3, "        ");
            }
        }
        if (button.equals("VOR")) {
            path.setAz(true);
            if (vor) {
                sparen = false;
                rassparen = true;
            }
            if (sparen) {
                path.lights.put("APK", false);
                path.lights.put("VOR", true);
                path.lights.put("DME", true);
                path.panels.put(1, "  108,00");
                path.panels.put(2, "  Аз   0");
                path.panels.put(3, "СПАРЕН П");
            } else {
                path.lights.put("APK", false);
                path.lights.put("VOR", true);
                path.lights.put("DME", false);
                path.panels.put(1, "  108,00");
                path.panels.put(2, "  Аз   0");
                path.panels.put(3, "       П");
            }
            path.setRoundState(State.AZ);
            vor = true;
        } else {
            vor = false;
            rassparen = false;
        }
        if (button.equals("APK")) {
            path.lights.put("APK", true);
            path.lights.put("VOR", false);
            path.lights.put("DME", false);
            path.panels.put(1, "   150,0");
            path.panels.put(2, "   150,0");
            path.panels.put(3, "КОМП ТЛФ");
        }
    }
}
