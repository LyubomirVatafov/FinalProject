package homeWorkPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String LoginPageUrl = "http://training.skillo-bg.com:4300/users/login";
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateTo(){
        driver.get(LoginPage.LoginPageUrl);
    }
    public void login(String username, String password) {
        enterUsernameOrEmail(username);
        enterPassword(password);
        clickSigIn();
    }
    public void enterUsernameOrEmail(String username) {
        WebElement usernameOrEmailField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameOrEmailField.sendKeys(username);
    }
    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);
    }
    public void clickSigIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.urlToBe(LoginPageUrl));
    }
}

