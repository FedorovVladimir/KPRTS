//import model.Buttons;
//import model.KPRTS;
//import model.Light;
//import org.junit.Test;
//
//import static junit.framework.TestCase.*;
//
//class KPRTSTest {
//
//    private KPRTS kprts = new KPRTS();
//
//    @Test
//    void clickApk_On() {
//        kprts.turnOn(Integer.parseInt(state));
//        assertTrue(kprts.click(Buttons.APK));
//    }
//
//    @Test
//    void clickApk_Off() {
//        assertFalse(kprts.click(Buttons.APK));
//    }
//
//    @Test
//    void clickAllButton() {
//        kprts.turnOn(Integer.parseInt(state));
//        for (Buttons button: Buttons.values()) {
//            assertTrue(kprts.click(button));
//        }
//    }
//
//    @Test
//    void turnOn() {
//        kprts.turnOn(Integer.parseInt(state));
//        assertTrue(kprts.isTurn());
//        assertEquals("   150,0", kprts.getPanel(1).getText());
//        assertEquals("   150,0", kprts.getPanel(2).getText());
//        assertEquals("комп тлф", kprts.getPanel(3).getText());
//        assertTrue(kprts.isOn(Light.APK));
//        assertEquals("   118,0", kprts.getPanel(4).getText());
//        assertEquals("   118,0", kprts.getPanel(5).getText());
//        assertEquals("пш      ", kprts.getPanel(6).getText());
//        assertTrue(kprts.isOn(Light.MB1));
//
//        kprts.turnOff();
//        assertFalse(kprts.isTurn());
//        assertEquals("        ", kprts.getPanel(1).getText());
//        assertEquals("        ", kprts.getPanel(2).getText());
//        assertEquals("        ", kprts.getPanel(3).getText());
//        assertFalse(kprts.isOn(Light.APK));
//        assertEquals("        ", kprts.getPanel(4).getText());
//        assertEquals("        ", kprts.getPanel(5).getText());
//        assertEquals("        ", kprts.getPanel(6).getText());
//        assertFalse(kprts.isOn(Light.MB1));
//    }
//
//    @Test
//    void click_Vor() {
//        kprts.turnOn(Integer.parseInt(state));
//        kprts.click(Buttons.VOR);
//        assertFalse(kprts.isOn(Light.APK));
//        assertTrue(kprts.isOn(Light.VOR));
//        assertTrue(kprts.isOn(Light.DME));
//    }
//
//    @Test
//    void click_Vor_Apk() {
//        kprts.turnOn(Integer.parseInt(state));
//        kprts.click(Buttons.VOR);
//        kprts.click(Buttons.APK);
//        assertTrue(kprts.isOn(Light.APK));
//        assertFalse(kprts.isOn(Light.VOR));
//        assertFalse(kprts.isOn(Light.DME));
//    }
//
//    @Test
//    void click_Vor_Apk_DME() {
//        kprts.turnOn(Integer.parseInt(state));
//        kprts.click(Buttons.VOR);
//        kprts.click(Buttons.APK);
//        kprts.click(Buttons.DME);
//        assertFalse(kprts.isOn(Light.APK));
//        assertFalse(kprts.isOn(Light.VOR));
//        assertTrue(kprts.isOn(Light.DME));
//    }
//
//    @Test
//    void click_Vor_Apk_DME_VOR() {
//        kprts.turnOn(Integer.parseInt(state));
//        kprts.click(Buttons.VOR);
//        kprts.click(Buttons.APK);
//        kprts.click(Buttons.DME);
//        kprts.click(Buttons.VOR);
//        assertFalse(kprts.isOn(Light.APK));
//        assertTrue(kprts.isOn(Light.VOR));
//        assertTrue(kprts.isOn(Light.DME));
//        kprts.click(Buttons.VOR);
//        assertFalse(kprts.isOn(Light.APK));
//        assertTrue(kprts.isOn(Light.VOR));
//        assertFalse(kprts.isOn(Light.DME));
//        kprts.click(Buttons.APK);
//        assertTrue(kprts.isOn(Light.APK));
//        assertFalse(kprts.isOn(Light.VOR));
//        assertFalse(kprts.isOn(Light.DME));
//        kprts.click(Buttons.VOR);
//        assertFalse(kprts.isOn(Light.APK));
//        assertTrue(kprts.isOn(Light.VOR));
//        assertFalse(kprts.isOn(Light.DME));
//        kprts.click(Buttons.DME);
//        assertFalse(kprts.isOn(Light.APK));
//        assertTrue(kprts.isOn(Light.VOR));
//        assertTrue(kprts.isOn(Light.DME));
//    }
//}
