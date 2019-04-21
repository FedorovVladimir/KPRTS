import model.Buttons;
import model.KPRTS;
import model.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KPRTSTest {

    private KPRTS kprts = new KPRTS();

    @Test
    void turnOn() {
        kprts.turnOn();
        assertTrue(kprts.isTurn());
        assertEquals("   150,0", kprts.getPanel(1).getText());
        assertEquals("   150,0", kprts.getPanel(2).getText());
        assertEquals("комп тлф", kprts.getPanel(3).getText());
        assertTrue(kprts.isOn(Light.APK));
        assertEquals("   118,0", kprts.getPanel(4).getText());
        assertEquals("   118,0", kprts.getPanel(5).getText());
        assertEquals("пш      ", kprts.getPanel(6).getText());
        assertTrue(kprts.isOn(Light.MB1));

        kprts.turnOff();
        assertFalse(kprts.isTurn());
        assertEquals("        ", kprts.getPanel(1).getText());
        assertEquals("        ", kprts.getPanel(2).getText());
        assertEquals("        ", kprts.getPanel(3).getText());
        assertFalse(kprts.isOn(Light.APK));
        assertEquals("        ", kprts.getPanel(4).getText());
        assertEquals("        ", kprts.getPanel(5).getText());
        assertEquals("        ", kprts.getPanel(6).getText());
        assertFalse(kprts.isOn(Light.MB1));
    }

    @Test
    void clickApk_On() {
        kprts.turnOn();
        assertTrue(kprts.click(Buttons.APK));
    }

    @Test
    void clickApk_Off() {
        assertFalse(kprts.click(Buttons.APK));
    }

    @Test
    void clickAllButton() {
        kprts.turnOn();
        for (Buttons button: Buttons.values()) {
            assertTrue(kprts.click(button));
        }
    }
}