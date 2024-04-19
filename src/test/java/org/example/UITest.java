package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UITest extends AbstractTest{
    private ChromeOptions options;
    private  WebDriver driver;
    private PageObject pageObject;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://gb.ru/login");
        pageObject = new PageObject(driver);

    }

    @Test
    void testGBNotEmailLogin() {
        pageObject.login("login", "password");

        Assertions.assertFalse(pageObject.getParsleyLogin().isEmpty());
    }

    @Test
    void testGBWithoutPassword() {
        pageObject.setLogin("login@login.ru");
        pageObject.clickEnterButton();

        Assertions.assertFalse(pageObject.getParsleyPassword().isEmpty());
    }

    @AfterEach
    public void close(){
        driver.quit();
    }

}
