package com.cucumber.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TextExtractor {
    public static String getCurrency(WebElement e) {
        String currencyElement = e.findElement(By.tagName("i")).getText();
        return currencyElement.replace("/month", "");
    }

    public static List<Double> getPricesList(List<WebElement> elementList) {
        List<Double> priceslist = new ArrayList<>();
        for (WebElement e : elementList) {
            String price = e.findElement(By.tagName("b")).getText();
            priceslist.add(Double.valueOf(price));
        }
        return priceslist;
    }
}
