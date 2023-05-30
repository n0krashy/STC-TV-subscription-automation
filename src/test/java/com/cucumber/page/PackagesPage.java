package com.cucumber.page;

import com.cucumber.core.TextExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.cucumber.core.TextExtractor.getPricesList;

public class PackagesPage {
    final static By prices = By.cssSelector("div[id^='currency-'].price");
    final static By types = By.id("name-lite");
    final static By country = By.id("country-name");
    final static By countrySelector = By.id("country");
    WebDriver driver;
    WebDriverWait wait;

    public PackagesPage(WebDriver driver) {
        this.driver = driver;
        // Defining Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        waitForPageToLoad();
    }

    public String getCountry() {
        return driver.findElement(country).getText();
    }

    public String getCurrency() {
        return TextExtractor.getCurrency(driver.findElement(prices));
    }

    public double getPrice(int i) {
        return getPricesList(driver.findElements(prices)).get(i);
    }

    public void getTypes() {
        driver.findElements(types);
    }

    public void openCountrySelector() {
        driver.findElement(countrySelector).click();
    }

    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(country));
    }

}
