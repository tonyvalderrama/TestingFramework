package test;

import com.epam.training.tony_valderrama.driver.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class CommonTestStuff {
    // Solo se va a usar un WebDriver para todas las pruebas
    protected static WebDriver driver;

    /* **
     * Métodos que se ejecutan antes de todas las pruebas para inicializar driver Singleton
     */
    @BeforeAll
    static void beforeAll()
    {
        driver = DriverManager.getDriver();
    }

    @AfterAll
    static void stopBrowser()
    {
        DriverManager.quitDriver();
    }
}
