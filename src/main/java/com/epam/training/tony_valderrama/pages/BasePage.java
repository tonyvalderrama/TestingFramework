package com.epam.training.tony_valderrama.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.epam.training.tony_valderrama.services.DriverManager;

import java.time.Duration;

/**
 * Una clase abstracta que inicializa el WebDriver
 * Nos permite implementar el patrón Simpleton, para tener un
 * solo driver para todas las clases
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> fluentWait;

    // Constructor
    public BasePage() {
        // Tomo el driver del DriverManager que hice
        this.driver = DriverManager.getDriver();
        // Hago una espera de máximo 15 segundos donde cada 500 milisegundos estoy
        // revisando si ya aparece la página ignorando el NoSuchElementException
        // (o sea que si aún no lo hallo, que siga intentando)
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        // Maximizo la ventana del navegador
        this.driver.manage().window().maximize();
    }
}
