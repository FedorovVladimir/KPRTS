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
