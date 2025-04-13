package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.*;

public class OrderConfirmationTest {
    private WebDriver driver;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("problem_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstItemToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillInfo("Alice", "Smith", "12345");
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    void confirmOrderMessage() {
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.finishOrder();

        FinishPage finish = new FinishPage(driver);
        String message = finish.getConfirmationMessage();

        Assertion Assertions =new Assertion();
        Assertions.assertEquals("Thank you for your order!", message);
    }
}

