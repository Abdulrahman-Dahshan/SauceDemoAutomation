import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    By errorMsg = By.cssSelector(".error-message-container");

    @Test
    public void validLogin() {
        login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLogin() {
        login("wrong_user", "wrong_pass");
        Assert.assertTrue(driver.findElement(errorMsg).isDisplayed());
    }

    @Test
    public void emptyLogin() {
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(errorMsg).isDisplayed());
    }
}