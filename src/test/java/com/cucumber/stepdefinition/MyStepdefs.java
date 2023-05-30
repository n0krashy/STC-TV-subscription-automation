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

    /**
     * Opens a new chrome browser
     */
    @BeforeAll
    public static void beforeAll() {
        driver = Driver.getInstanceUsingDoubleLocking();
        pagesHelper = new PagesHelper(driver);
    }

    /**
     * Quit the driver after finishing all the scenarios
     */
    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    /**
     * Opens the intended URL and maximize it
     */
    @Given("I have opened the link")
    public void iHaveOpenedTheLink() {
        driver = pagesHelper.initiate();
    }

    /**
     * Validates the current country
     *
     * @param country the country name to validate
     */
    @Given("I am on {string}'s page")
    public void checkCountry(String country) {
        pagesHelper.checkCountry(country);
    }

    /**
     * Validates currency
     *
     * @param currency the currency to validate
     */
    @Then("the currency should be {string}")
    public void checkCurrency(String currency) {
        pagesHelper.checkCurrency(currency);
    }

    /**
     * Validates lite package price
     *
     * @param litePackagePrice lite package price
     */
    @And("the lite package price should be {double}")
    public void checkLitePackagePrice(double litePackagePrice) {
        pagesHelper.checkLitePackagePrice(litePackagePrice);
    }

    /**
     * Validates classic package price
     *
     * @param classicPackagePrice classic package price
     */
    @And("the classic package price should be {double}")
    public void checkClassicPackagePrice(double classicPackagePrice) {
        pagesHelper.checkClassicPackagePrice(classicPackagePrice);
    }

    /**
     * Validates premium package price
     *
     * @param premiumPackagePrice premium package price
     */
    @And("the premium package price should be {double}")
    public void checkPremiumPackagePrice(double premiumPackagePrice) {
        pagesHelper.checkPremiumPackagePrice(premiumPackagePrice);
    }

    /**
     * Changes country if not the intended country
     *
     * @param country String of country's name
     */
    @Given("change country if not {string}")
    public void changeCountryIfNot(String country) {
        pagesHelper.changeCountry(country);
    }

    /**
     * Closes the driver window after finishing the scenario
     */
    @AfterTest
    public void after() {
        driver.close();
    }
}
