package homeworkObject;

import homeWorkPageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class EditPublicInfoTest extends TestObject{

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Lyubomir1", "890606Veronika","Lyubomir1","Test new info2"}};
    }
    @Test (dataProvider = "getUsers")
public void testEditPublicInfo(String user, String password, String name, String publicInfo) {
        WebDriver driver = super.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        HeaderPage header = new HeaderPage(driver);
        header.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded());
        loginPage.enterUsernameOrEmail(user);
        loginPage.enterPassword(password);
        loginPage.clickSigIn();

        Assert.assertTrue(homePage.isUrlLoaded());
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded());
        profilePage.clickEditButton();

        String username = profilePage.getUserName();
        Assert.assertEquals(username,name,"Username is incorrect");

        ModifyProfilePage modifyProfilePage = new ModifyProfilePage(driver);
        String modifyProfileText = modifyProfilePage.getModifyProfileText();
        Assert.assertEquals(modifyProfileText,"Modify Your Profile");

        modifyProfilePage.enterProfileInfo(publicInfo);
        modifyProfilePage.clickSaveButton();

        Boolean publicInfoText = profilePage.getPublicInfoText();
        Assert.assertTrue(publicInfoText);

    }
}

