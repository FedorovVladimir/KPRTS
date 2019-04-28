package bdd;

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
        assertTrue(kprts.isLight(lightName));
    }

    @Then("^На панели \"([^\"]*)\" текст \"([^\"]*)\"$")
    public void наПанелиТекст(String numberPanel, String text) {
        assertEquals(text, kprts.getTextFromPanel(Integer.parseInt(numberPanel)));
    }

    @Then("^Не горит \"([^\"]*)\"$")
    public void неГорит(String lightName) {
        assertFalse(kprts.isLight(lightName));
    }

    @When("^Я нажал кнопку \"([^\"]*)\"$")
    public void яНажалКнопку(String buttonName) {
        kprts.click(buttonName);
    }

    @When("^Я повернул крутилку \"([^\"]*)\" на \"([^\"]*)\"$")
    public void яПовернулКрутилкуНа(String name, String size) {
        if (name.equals("1")) {
            kprts.clickRight(1, Integer.parseInt(size));
        } else {
            kprts.clickRight(2, Integer.parseInt(size));
        }
    }
}
