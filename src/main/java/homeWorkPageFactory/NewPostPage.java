package homeWorkPageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage {
    public static final String newPostUrl = "http://training.skillo-bg.com:4300/posts/create";

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input")
    private WebElement uploadImage;
    @FindBy(xpath = "//*[@class='image-preview']")
    private WebElement picture;
    @FindBy(xpath = "//*[@name='caption']")
    private WebElement captionField;
    @FindBy(id = "create-post")
    private WebElement postButton;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(newPostUrl));
    }
    public void uploadPicture(File file){
        uploadImage.sendKeys(file.getAbsolutePath());
    }
    public boolean isPictureVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            return wait.until(ExpectedConditions.visibilityOf(picture)).isDisplayed();
        }catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void enterCaption(String caption) {
        captionField.sendKeys(caption);
    }
    public void clickCreatePostButton() {
        postButton.click();
    }
}
