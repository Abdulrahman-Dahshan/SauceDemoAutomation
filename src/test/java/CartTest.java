import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    By cartIcon = By.cssSelector(".shopping_cart_link");
    By badge = By.cssSelector(".shopping_cart_badge");

    @Test
    public void addSingleItem() {
        login("standard_user", "secret_sauce");

        addItem("#add-to-cart-sauce-labs-backpack");

        Assert.assertEquals(driver.findElement(badge).getText(), "1");
    }

    @Test
    public void addMultipleItems() {
        login("standard_user", "secret_sauce");

        addItem("#add-to-cart-sauce-labs-backpack");
        addItem("#add-to-cart-sauce-labs-bike-light");
        addItem("#add-to-cart-sauce-labs-bolt-t-shirt");

        Assert.assertEquals(driver.findElement(badge).getText(), "3");
    }

    @Test
    public void openCart() {
        login("standard_user", "secret_sauce");

        addItem("#add-to-cart-sauce-labs-backpack");

        driver.findElement(cartIcon).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
}