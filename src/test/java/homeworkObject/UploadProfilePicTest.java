package homeworkObject;

import homeWorkPageObject.HeaderPage;
import homeWorkPageObject.HomePage;
import homeWorkPageObject.LoginPage;
import homeWorkPageObject.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class UploadProfilePicTest extends TestObject {

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        File profilePicture = new File("src/main/resources/picture/TestPic.jpg");
        File profilePicture2 = new File("src/main/resources/picture/testPic2.jpg");
        return new Object[][]{{"Lyubomir1", "890606Veronika",profilePicture},
                {"vatafoaw@abv.bg", "890606Veronika",profilePicture2}};
    }

        @Test(dataProvider = "getUsers")
        public void testUploadProfilePic (String user, String password, File file){
            WebDriver driver = super.getDriver();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.navigateTo();
            loginPage.login(user,password);

            HomePage homePage = new HomePage(driver);
            Assert.assertTrue(homePage.isUrlLoaded());

            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.clickProfile();

            ProfilePage profilePage = new ProfilePage(driver);
            Assert.assertTrue(profilePage.isUrlLoaded());

            profilePage.clickUploadImage(file);
            profilePage.isArialLabelDisplayed();
            Assert.assertTrue(profilePage.isArialLabelDisplayed());
        }
    }

