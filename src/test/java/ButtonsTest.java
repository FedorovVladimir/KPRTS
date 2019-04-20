import model.KPRTS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonsTest {

    private KPRTS kprts = new KPRTS();

    @Test
    public void turnOn() {
        kprts.turnOn();
        assertTrue(kprts.isTurn());
    }

    @Test
    public void clickApk() {
        kprts.turnOn();
        kprts.clickApk();
        assertTrue(kprts.isApkOn());
        kprts.clickApk();
        assertTrue(kprts.isApkOff());
    }

    @Test
    public void clickVor() {
        kprts.turnOn();
        kprts.clickVor();
        assertTrue(kprts.isVorOn());
        kprts.clickVor();
        assertTrue(kprts.isVorOff());
    }
}
