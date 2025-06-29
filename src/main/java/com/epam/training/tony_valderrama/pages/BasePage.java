package com.epam.training.tony_valderrama.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    protected abstract void openPage();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
