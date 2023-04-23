package homeWorkPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModifyProfilePage {
    private final WebDriver driver;

    public ModifyProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getModifyProfileText() {
    WebElement modifyProfileText = driver.findElement(By.tagName("h4"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(modifyProfileText));
    return modifyProfileText.getText();
    }
    public void enterProfileInfo(String profileInfo){
        WebElement profileInfoField = driver.findElement(By.xpath("//*[@formcontrolname='publicInfo']"));
        profileInfoField.clear();
        profileInfoField.sendKeys(profileInfo);
    }
    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
        saveButton.click();
    }
}
