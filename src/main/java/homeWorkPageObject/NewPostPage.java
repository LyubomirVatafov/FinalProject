package homeWorkPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage {
    public static final String newPostUrl = "http://training.skillo-bg.com:4300/posts/create";
    private final WebDriver driver;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(newPostUrl));
    }
        public void uploadPicture(File file){
            WebElement uploadImage = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input"));
            uploadImage.sendKeys(file.getAbsolutePath());
        }
        public boolean isPictureVisible() {
            try {
                WebElement picture = driver.findElement(By.xpath("//*[@class='image-preview']"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                return wait.until(ExpectedConditions.visibilityOf(picture)).isDisplayed();
            }catch (NoSuchElementException e) {
                e.printStackTrace();
                return false;
            }
        }
        public void enterCaption(String caption) {
        WebElement captionField = driver.findElement(By.xpath("//*[@name='caption']"));
        captionField.sendKeys(caption);
        }
        public void clickCreatePostButton() {
        WebElement postButton = driver.findElement(By.id("create-post"));
        postButton.click();
        }
}
