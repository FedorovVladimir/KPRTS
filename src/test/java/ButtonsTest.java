import model.Buttons;
import model.KPRTS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonsTest {

    private KPRTS kprts = new KPRTS();

    @Test
    void turnOn() {
        kprts.turnOn();
        assertTrue(kprts.isTurn());
    }

    @Test
    void clickApk_On() {
        kprts.turnOn();
        kprts.click(Buttons.APK);
        assertTrue(kprts.isOn(Buttons.APK));
        kprts.click(Buttons.APK);
        assertTrue(kprts.isOff(Buttons.APK));
    }

    @Test
    void clickApk_Off() {
        kprts.click(Buttons.APK);
        assertFalse(kprts.isOn(Buttons.APK));
        kprts.click(Buttons.APK);
        assertTrue(kprts.isOff(Buttons.APK));
    }

    @Test
    void clickAllButton() {
        kprts.turnOn();
        for (Buttons button: Buttons.values()) {
            kprts.click(button);
            assertTrue(kprts.isOn(button));
            kprts.click(button);
            assertTrue(kprts.isOff(button));
        }
    }
}
