package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk/");

    }

    @Test
    public void relativeLocatorTest() {

        // find the height and weight labels using css selector
        WebElement googleLogo = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img"));
        WebElement searchBar = driver.findElement(By.className("gLFyf"))
                .below(googleLogo);

        searchBar.sendKeys("Selenium");


    }
    @After
    public void tearDown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}