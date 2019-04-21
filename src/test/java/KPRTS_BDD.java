import cucumber.api.java.en.When;
import model.KPRTS;

public class KPRTS_BDD {

    private KPRTS kprts = new KPRTS();

    @When("^Я поворачиваю рычаг в положение \"([^\"]*)\"$")
    public void яПоворачиваюРычагВПоложение(String state) throws Throwable {
        kprts.turnOn(Integer.parseInt(state));
    }
}
