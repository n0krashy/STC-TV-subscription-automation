package com.cucumber.core;

import com.cucumber.page.PackagesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class PagesHelper {
    double actualPrice;
    String actualCurrency, actualCountry;
    WebDriver driver;
    PackagesPage packagesPage;

    public PagesHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver initiate() {
        driver.manage().window().maximize();
        driver.get("https://subscribe.stctv.com/sa-en");
        packagesPage = new PackagesPage(driver);
        return driver;
    }

    public void checkCountry(String country) {
        actualCountry = packagesPage.getCountry();
        assertEquals(actualCountry, country);
    }

    public void checkCurrency(String currency) {
        actualCurrency = packagesPage.getCurrency();
        assertEquals(actualCurrency, currency);
    }

    public void checkLitePackagePrice(double litePackagePrice) {
        actualPrice = packagesPage.getPrice(0);
        assertEquals(actualPrice, litePackagePrice);
    }

    public void checkClassicPackagePrice(double classicPackagePrice) {
        actualPrice = packagesPage.getPrice(1);
        assertEquals(actualPrice, classicPackagePrice);
    }

    public void checkPremiumPackagePrice(double premiumPackagePrice) {
        actualPrice = packagesPage.getPrice(2);
        assertEquals(actualPrice, premiumPackagePrice);
    }

    public void changeCountry(String country) {
        if (!country.equals(packagesPage.getCountry())) {
            packagesPage.openCountrySelector();
            String myId = switch (country) {
                case "KSA" -> "sa";
                case "Kuwait" -> "kw";
                case "Bahrain" -> "bh";
                default -> null;
            };
            driver.findElement(By.id(myId)).click();
        }
    }
}
