package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.*;

public class AddToCartTest {
    private WebDriver driver;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("problem_user", "secret_sauce");
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    void addItemToCart() {
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstItemToCart();
        inventory.goToCart();

        Assertion Assertions = new Assertion();
        Assertions.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
}

