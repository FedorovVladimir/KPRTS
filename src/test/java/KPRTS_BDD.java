import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.KPRTS;

import static junit.framework.TestCase.*;

public class KPRTS_BDD {

    private KPRTS kprts = new KPRTS();

    @When("^Я повернул рычаг в положение \"([^\"]*)\"$")
    public void яПовернулРычагВПоложение(String state) {
        kprts.turnOn(Integer.parseInt(state));
    }

    @Then("^Горит \"([^\"]*)\"$")
    public void горит(String lightName) {
        assertTrue(kprts.isOnLight(lightName));
    }

    @Then("^На панели \"([^\"]*)\" текст \"([^\"]*)\"$")
    public void наПанелиТекст(String numberPanel, String text) {
        assertEquals(text, kprts.getPanel(Integer.parseInt(numberPanel)).getText());
    }

    @Then("^Не горит \"([^\"]*)\"$")
    public void неГорит(String lightName) {
        assertFalse(kprts.isOnLight(lightName));
    }

    @When("^Я нажал кнопку \"([^\"]*)\"$")
    public void яНажалКнопку(String buttonName) {
        kprts.click(buttonName);
    }
}
