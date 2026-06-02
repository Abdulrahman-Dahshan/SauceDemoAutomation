import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    By cart = By.cssSelector(".shopping_cart_link");
    By checkoutBtn = By.id("checkout");

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    By successMsg = By.className("complete-header");
    By errorMsg = By.cssSelector(".error-message-container");

    @Test
    public void successfulCheckout() {

        login("standard_user", "secret_sauce");

        addItem("#add-to-cart-sauce-labs-backpack");

        driver.findElement(cart).click();
        driver.findElement(checkoutBtn).click();

        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(postalCode).sendKeys("12345");

        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();

        Assert.assertEquals(
                driver.findElement(successMsg).getText(),
                "Thank you for your order!"
        );
    }

    @Test
    public void checkoutWithoutInfo() {

        login("standard_user", "secret_sauce");

        addItem("#add-to-cart-sauce-labs-backpack");

        driver.findElement(cart).click();
        driver.findElement(checkoutBtn).click();

        driver.findElement(continueBtn).click();

        Assert.assertTrue(
                driver.findElement(errorMsg).isDisplayed()
        );
    }
}