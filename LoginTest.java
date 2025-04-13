package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void problemUserCanLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("problem_user", "secret_sauce");

        // Assert current URL contains "inventory"
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed for problem_user.");
    }
}

