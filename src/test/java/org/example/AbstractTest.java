package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;


public class AbstractTest {

    @BeforeAll
    public static void StartSetUp(){
        WebDriverManager.chromedriver().setup();

    }

}
