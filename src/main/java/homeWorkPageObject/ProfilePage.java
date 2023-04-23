package homeWorkPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ProfilePage {
    public static final String profilePageUrl = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlContains(profilePageUrl));

    }

    public String getUserName() {
        WebElement username = driver.findElement(By.tagName("h2"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
        return username.getText();
    }
    public void clickEditButton() {
        WebElement editButton = driver.findElement(By.xpath("//*[@class='fas fa-user-edit ng-star-inserted']"));
        editButton.click();
    }
    public Boolean getPublicInfoText() {
        WebElement publicInfoText = driver.findElement(By.xpath("//app-profile"));
        return publicInfoText.isDisplayed();
    }
    public void clickUploadImage(File file) {
        WebElement uploadImage = driver.findElement(By.id("upload-img"));
        uploadImage.sendKeys(file.getAbsolutePath());
    }
    public void clickNewPostButton() {
        WebElement newPostButton = driver.findElement(By.xpath("//*[@class='far fa-plus-square fa-lg']"));
        newPostButton.click();
    }
    public boolean isImageDisplayed() {
        WebElement image = driver.findElement(By.xpath("//*[@class='post-img']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(image));
        return image.isDisplayed();
    }
    public boolean isArialLabelDisplayed() {
        WebElement arialLabel = driver.findElement(By.xpath("//*[@aria-label='Profile picture updated']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(arialLabel));
        return arialLabel.isDisplayed();
    }
}

