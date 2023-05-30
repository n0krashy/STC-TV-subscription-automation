package com.cucumber.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TextExtractor {
    /**
     * This function returns prices list of all subscriptions
     *
     * @param currencyWebElement webElement of price
     * @return currency string
     */
    public static String getCurrency(WebElement currencyWebElement) {
        String currencyElement = currencyWebElement.findElement(By.tagName("i")).getText();
        return currencyElement.replace("/month", "");
    }

    /**
     * This function returns prices list of all subscriptions
     *
     * @param pricesWebElementList a list of prices web elements
     * @return a list of prices of subscription
     */
    public static List<Double> getPricesList(List<WebElement> pricesWebElementList) {
        List<Double> priceslist = new ArrayList<>();
        for (WebElement priceWebELement : pricesWebElementList) {
            String price = priceWebELement.findElement(By.tagName("b")).getText();
            priceslist.add(Double.valueOf(price));
        }
        return priceslist;
    }

}
