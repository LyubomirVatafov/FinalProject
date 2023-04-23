package homeWorkPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    private final WebDriver driver;

    public HeaderPage (WebDriver driver) {
        this.driver = driver;

    }
    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();
    }
    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileButton.click();
    }
}
