package homeWorkPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public final static String HomePageUrl = "http://training.skillo-bg.com:4300/posts/all";
    private final WebDriver driver;

    public  HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.urlToBe(HomePage.HomePageUrl));
    }
    public void navigateTo() {
        this.driver.get(HomePageUrl);
    }
}
