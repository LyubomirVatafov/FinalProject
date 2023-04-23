package homeworkObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestObject {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
        @AfterMethod
        protected final void tearDownTest () {
            if (this.driver != null) {
                this.driver.quit();
            }
    }

            public WebDriver getDriver () {
                return driver;
            }
        }
