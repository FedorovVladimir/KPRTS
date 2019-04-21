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
        assertTrue(kprts.isOn(Light.APK));
        assertTrue(kprts.isOn(Light.MB1));
        assertEquals("   150,0", kprts.getPanel(1).getText());
        assertEquals("   150,0", kprts.getPanel(2).getText());
        assertEquals("комп тлф", kprts.getPanel(3).getText());
        assertEquals("   118,0", kprts.getPanel(4).getText());
        assertEquals("   118,0", kprts.getPanel(5).getText());
        assertEquals("пш      ", kprts.getPanel(6).getText());
        kprts.turnOff();
        assertFalse(kprts.isOn(Light.APK));
        assertFalse(kprts.isOn(Light.MB1));
    }

    @Test
    void clickApk_On() {
        kprts.turnOn();
        kprts.click(Buttons.APK);
        assertTrue(kprts.isOn(Buttons.APK));
        kprts.click(Buttons.APK);
        assertFalse(kprts.isOn(Buttons.APK));
    }

    @Test
    void clickApk_Off() {
        kprts.click(Buttons.APK);
        assertFalse(kprts.isOn(Buttons.APK));
        kprts.click(Buttons.APK);
        assertFalse(kprts.isOn(Buttons.APK));
    }

    @Test
    void clickAllButton() {
        kprts.turnOn();
        for (Buttons button: Buttons.values()) {
            kprts.click(button);
            assertTrue(kprts.isOn(button));
            kprts.click(button);
            assertFalse(kprts.isOn(button));
        }
    }
}
