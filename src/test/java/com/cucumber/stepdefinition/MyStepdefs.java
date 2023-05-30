package com.cucumber.stepdefinition;

import com.cucumber.core.Driver;
import com.cucumber.core.PagesHelper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class MyStepdefs {
    static PagesHelper pagesHelper;
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = Driver.getInstanceUsingDoubleLocking();
        pagesHelper = new PagesHelper(driver);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Given("I have opened the link")
    public void iHaveOpenedTheLink() {
        driver = pagesHelper.initiate();
    }

    @Given("I am on {string}'s page")
    public void checkCountry(String country) {
        pagesHelper.checkCountry(country);
    }

    @Then("the currency should be {string}")
    public void checkCurrency(String currency) {
        pagesHelper.checkCurrency(currency);
    }

    @And("the lite package price should be {double}")
    public void checkLitePackagePrice(double litePackagePrice) {
        pagesHelper.checkLitePackagePrice(litePackagePrice);
    }

    @And("the classic package price should be {double}")
    public void checkClassicPackagePrice(double classicPackagePrice) {
        pagesHelper.checkClassicPackagePrice(classicPackagePrice);
    }

    @And("the premium package price should be {double}")
    public void checkPremiumPackagePrice(double premiumPackagePrice) {
        pagesHelper.checkPremiumPackagePrice(premiumPackagePrice);
    }

    @Given("change country if not {string}")
    public void changeCountryIfNot(String country) {
        pagesHelper.changeCountry(country);
    }

    @AfterTest
    public void after() {
        driver.close();
    }
}
