package homeworkObject;

import homeWorkPageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class CreatePostTest extends TestObject{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        File picture = new File("src/main/resources/picture/postPic.jpg");
        return new Object[][]{{"Lyubomir1","890606Veronika",picture,"Test new Post"}};
    }
    @Test(dataProvider = "getUsers")
    public void testCreatePostFromProfilePage(String user, String password, File file, String caption) {
        WebDriver driver = super.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded());
        profilePage.clickNewPostButton();

        NewPostPage newPostPage = new NewPostPage(driver);
        Assert.assertTrue(newPostPage.isUrlLoaded());

        newPostPage.uploadPicture(file);
        Assert.assertTrue(newPostPage.isPictureVisible());

        newPostPage.enterCaption(caption);
        newPostPage.clickCreatePostButton();

        Assert.assertTrue(profilePage.isImageDisplayed());
    }
}
