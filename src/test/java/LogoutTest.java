import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    By menuButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");
    By loginButton = By.id("login-button");

    @Test
    public void logoutSuccessfully() {

        login("standard_user", "secret_sauce");

        driver.findElement(menuButton).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        ).click();

        Assert.assertTrue(
                driver.findElement(loginButton).isDisplayed()
        );
    }
}