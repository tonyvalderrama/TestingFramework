package com.epam.training.tony_valderrama.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.training.tony_valderrama.services.DriverManager;

import java.time.Duration;
import java.util.List;

/**
 * Esta clase permite probar el login de la página
 * saucedemo.com
 */
public class LoginPage {
    // Página que voy a abrir
    private static final String PAGE_URL = "https://www.saucedemo.com/";
    private WebDriver driver;

    /**
     * Constructor que inicializa el WebDriver
     */
    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }

    /**
     * Metodo que prueba el login de la página saucedemo
     *
     * @param userName el nombre del usuario
     * @param password constraseña del usuario
     */
    public void login(String userName,String password) {
        // Creo el Webdriver y abro la página en el navegador
        driver = DriverManager.getDriver();
        driver.get(PAGE_URL);
        // Mando nombre y password de usuario.
        enterUser(userName);
        enterPassword(password);
    }

    /**
     * Metodo que asigna el username en el elemento input de la página
     *
     * @param userName el nombre del usuario
     */
    public void enterUser(String userName) {
        // Uso método de la clase que espera a que el locator se cargue
        WebElement userNameInput = waitForElement(By.xpath("//*[@id=\"user-name\"]"));
        // Mando texto al input box
        userNameInput.sendKeys(userName);
    }

    /**
     * Metodo que asigna el password en el elemento input de la página
     *
     * @param password la contraseña
     */
    public void enterPassword(String password) {
        WebElement passwordInput = waitForElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys(password);
    }

    /**
     * Metodo que hace click al botón de Login
     */
    public void clickLoginButton() {
        WebElement loginButton = waitForElement(By.xpath("//*[@id=\"login-button\"]"));
        // Hago click en el botón
        loginButton.click();
    }

    /**
     * Metodo que devuelve el mensaje de error
     *
     * @return la cadena con el texto del mensaje de error, cadena vacía si no hay error
     */
    public String getErrorMessage() {
        // Busco la lista de elementos. Aunque solo es 1, puedo ver si está vacío
        // Y me espero 1 segundo para ver si aparece (debería ser menos, pero en fin)
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//h3[@data-test='error']")));
        // Si no hay error, devuelvo cadena vacía
        if (elements.isEmpty()) {
            return "";
        }
        // Si existe, devuelvo el texto sin el "Epic sadface: " que pone al principio
        String textoError = elements.getFirst().getText();
        return textoError.substring("Epic sadface: ".length());
    }

    /**
     * Metodo que devuelve el URL de la página
     *
     * @return la cadena con el texto con el URL de la página en el navegador
     */
    public String getURL() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("saucedemo"));
        return driver.getCurrentUrl();
    }

    /**
     * Metodo que espera a que se cargue un elemento de la página.
     * Sirve para cualquier elemento, con tal de pasar el locator
     *
     * @param locator es el locator (WebElement) que se desea obtener
     */
    private WebElement waitForElement(By locator) {
        // Espero para crear referencias a la caja de texto del input box de nombre del usuario
        // (preferiría usar el By.id pero el proyecto especifica que use xPath
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Devuelvo el WebElement cuando ya se cargó
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
