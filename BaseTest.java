package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    void setup() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    void teardown() {
        WebDriver driver = null;
        driver.quit();
    }
}
