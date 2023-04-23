package homeWorkPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;

    public static final String profilePageUrl = "http://training.skillo-bg.com:4300/users/";

    @FindBy(tagName = "h2")
    private WebElement username;
    @FindBy(xpath = "//*[@class='fas fa-user-edit ng-star-inserted']")
    private WebElement editButton;
    @FindBy(xpath = "//app-profile")
    private WebElement publicInfoText;
    @FindBy(id = "upload-img")
    private WebElement uploadImage;
    @FindBy(xpath = "//*[@class='far fa-plus-square fa-lg']")
    private WebElement newPostButton;
    @FindBy(xpath = "//*[@class='post-img']")
    private WebElement image;
    @FindBy(xpath = "//*[@aria-label='Profile picture updated']")
    private WebElement arialLabel;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlContains(profilePageUrl));

    }

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
        return username.getText();
    }
    public void clickEditButton() {
        editButton.click();
    }
    public Boolean getPublicInfoText() {
        return publicInfoText.isDisplayed();
    }
    public void clickUploadImage(File file) {
        uploadImage.sendKeys(file.getAbsolutePath());
    }
    public void clickNewPostButton() {
        newPostButton.click();
    }
    public boolean isImageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(image));
        return image.isDisplayed();
    }
    public boolean isArialLabelDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(arialLabel));
        return arialLabel.isDisplayed();
    }
}

