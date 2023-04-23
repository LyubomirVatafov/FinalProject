package homeWorkPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    private final WebDriver driver;
    @FindBy(id = "nav-link-login")
    private WebElement loginButton;

    @FindBy(id = "nav-link-profile")
    private WebElement profileButton;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickLogin(){
        loginButton.click();
    }
    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }
}
