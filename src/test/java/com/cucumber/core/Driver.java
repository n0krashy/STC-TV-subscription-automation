package com.cucumber.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver instance;

    private Driver() {
    }

    public static WebDriver getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new ChromeDriver();
                }
            }
        }
        return instance;
    }

}
