package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// Opciones de Cucumber
@CucumberOptions(features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json"},
    monochrome = true)
// Heredar de esta clase permite correr las pruebas en paralelo
public class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Metodo que prueba el login de la página saucedemo
     * Corre las pruebas en paralelo (gracias DataProvider que puede
     * ejecutar pruebas múltiples y al parallel = true)
     *
     * @return matriz con todos los escenarios del archivo feature
     * para que TestNG los ejecute uno por uno.
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
