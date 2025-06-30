package com.epam.training.tony_valderrama.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    // Constructor privado. Para el patrón Singleton - ayuda a tener solo un driver
    // para todos los objetos que lo requieren
    private DriverManager() {}

    /**
     * Metodo que devuelve la instancia a un WebDriver. Solo permite un solo driver activo
     * para todas las pruebas
     *
     * @return la cadena con el texto del mensaje de error, cadena vacía si no hay error
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "firefox");
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Metodo que revisa si el driver existe, cierro ventana y lo hago igual a null
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
