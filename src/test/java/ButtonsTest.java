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

}
