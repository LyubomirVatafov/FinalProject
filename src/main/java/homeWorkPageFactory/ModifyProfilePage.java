package homeWorkPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModifyProfilePage {
    private final WebDriver driver;
    @FindBy(tagName = "h4")
    private WebElement modifyProfileText;
    @FindBy(xpath = "//*[@formcontrolname='publicInfo']")
    private WebElement profileInfoField;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement saveButton;

    public ModifyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getModifyProfileText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modifyProfileText));
        return modifyProfileText.getText();
    }
    public void enterProfileInfo(String profileInfo){
        profileInfoField.clear();
        profileInfoField.sendKeys(profileInfo);
    }
    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
}

