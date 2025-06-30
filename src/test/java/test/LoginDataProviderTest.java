package test;

import com.epam.training.tony_valderrama.driver.DriverManager;
import com.epam.training.tony_valderrama.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/***
 * Clase que hace un test parametrizado usando el Data Provider de TestNG
 * No es necesario si ya estás usando Cucumber, pero ahí vamos de todos modos
 */
public class LoginDataProviderTest {

    private WebDriver driver;
    private final String LOGIN_MESSAGE = "Correct login";
    private static final Logger logger = LoggerFactory.getLogger(LoginDataProviderTest.class);

    /***
     * Metodo que, antes de las pruebas, hago referencia a mi Singleton driver
     */
    @BeforeClass
    void beforeClass()
    {
        driver = DriverManager.getDriver();
    }

    /***
     * Metodo que cierra el driver
     */
    @AfterClass
    void afterClass() {
        DriverManager.quitDriver();
    }

    /***
     * Metodo que proporciona los datos de prueba para hacer login
     *
     * @return matriz con usuario, contraseña y si puede entrar
     */
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true},
                {"performance_glitch_user", "secret_sauce", true},
                {"error_user", "secret_sauce", true},
                {"visual_user", "secret_sauce", true}
        };
    }

    /***
     * Metodo que prueba el login con los datos de loginData()
     *
     * @param username nombre de usuario
     * @param password contraseña
     * @param couldLogin si pudo entrar o no
     */
    @Test(dataProvider = "loginData")
    public void loginTest(String username,String password,boolean couldLogin) {
        // Pongo entrada en el log
        logger.info("Prueba con Data Provider - Usuario: {}, Password: {} ",username,password);
        // Creo y cargo página con el driver Singleton
        LoginPage page = new LoginPage(driver);
        page.login(username,password);
        // Reviso si pudo entrar o no
        if (couldLogin) {
            assertThat(page.getErrorMessage(),equalTo(LOGIN_MESSAGE));
        } else {
            assertThat(page.getErrorMessage(),not(equalTo(LOGIN_MESSAGE)));
        }
    }
}
